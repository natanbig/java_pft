package co.stqa.pft.addressbook.tests;

import co.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    
    @Test
    public void testContactDeletion() {
        app.getNavigationManager().gotoHomePage();
        if(!app.getContactHelper().isThereContact(0)){
            app.getContactHelper().createContact(new ContactData("test1", "test2", "test3", "ttt", "dddd", "aser 11", "23434334", "45123123", "434234324", "test@test.com", "test1"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().DeleteSelectedContact(0);
        List<ContactData>  after =app.getContactHelper().getContactList();
        Assert.assertEquals(after.size()+1,before.size());

    }



}
