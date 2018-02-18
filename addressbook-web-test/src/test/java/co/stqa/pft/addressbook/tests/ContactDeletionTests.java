package co.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    
    @Test
    public void testContactDeletion() {
        app.getNavigationManager().gotoHomePage();
        app.getContactHelper().goToContactPage();
        app.getContactHelper().selectContact(1);
        app.getContactHelper().deleteSelectedContacts();
    }

}
