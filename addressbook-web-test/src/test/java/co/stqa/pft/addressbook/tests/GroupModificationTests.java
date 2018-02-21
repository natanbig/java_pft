package co.stqa.pft.addressbook.tests;

import co.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

/**
 * Created by natan.radostin on 2/18/2018.
 */
public class GroupModificationTests extends TestBase {


  @Test
  public void  testGroupModification(){
    app.getNavigationManager().gotoGroupPage();
    if(!app.getGroupHelper().isThereGroup()) {
      app.getGroupHelper().createGroup(new GroupData("newtest1", "newtest2", "newtest3"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("modtest1","mod2",null));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();

  }
}
