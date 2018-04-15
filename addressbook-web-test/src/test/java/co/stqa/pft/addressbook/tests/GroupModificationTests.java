package co.stqa.pft.addressbook.tests;

import co.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Created by natan.radostin on 2/18/2018.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if(app.group().list().size()==0) {
      app.group().create(new GroupData("test1", "newtest2", null));
    }
  }

  @Test
  public void  testGroupModification(){


    List<GroupData> before = app.group().list();
    int index = before.size()-1;
    GroupData group =new GroupData(before.get(index).getId(),"test1","test2","test3");
    app.group().modify(index, group);
    List<GroupData> after =app.group().list();
    Assert.assertEquals(after.size(),before.size());

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId=(o1, o2) -> Integer.compare(o1.getId(),o2.getId()) ;
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }


}
