package co.stqa.pft.addressbook.tests;

import co.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by natan.radostin on 2/18/2018.
 */
public class GroupModificationTests extends TestBase {


  @Test
  public void  testGroupModification(){
    app.getNavigationManager().gotoGroupPage();
    if(!app.getGroupHelper().isThereGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", "newtest2", null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size()-1);
    app.getGroupHelper().initGroupModification();
    GroupData group =new GroupData(before.get(before.size()-1).getId(),"test1","test2","test3");
    app.getGroupHelper().fillGroupForm(group);

    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after =app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size());

    before.remove(before.size()-1);
    before.add(group);
    Comparator<? super GroupData> byId=(o1, o2) -> Integer.compare(o1.getId(),o2.getId()) ;
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
