package co.stqa.pft.addressbook.tests;

import co.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTests extends TestBase {


    @Test
    public void testGroupDeletion() {
        app.getNavigationManager().gotoGroupPage();
        if(!app.getGroupHelper().isThereGroup()){
            app.getGroupHelper().createGroup(new GroupData("test1",null,null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size()-1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after =app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size()+1,before.size());
        before.remove(before.size()-1);
        Assert.assertEquals(before,after);
    }



}
