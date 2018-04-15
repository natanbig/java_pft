package co.stqa.pft.addressbook.tests;

import co.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    List<GroupData> before =app.group().list();
    GroupData group = new GroupData("test1", "test2", "test3");
    app.group().create(group);
    List<GroupData> after =app.group().list();
    Assert.assertEquals(after.size(),before.size()+1);
    //group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    before.add(group);
    Comparator<? super GroupData> byId=(o1, o2) -> Integer.compare(o1.getId(),o2.getId()) ;
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
