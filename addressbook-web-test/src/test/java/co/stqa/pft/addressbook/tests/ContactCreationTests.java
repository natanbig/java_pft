package co.stqa.pft.addressbook.tests;

import co.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {




  @Test
  public void testContactCreation() {
    app.getNavigationManager().gotoHomePage();
    app.getContactHelper().goToContactPage();
    app.getContactHelper().initiateContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("test1", "test2", "test3", "ttt", "dddd", "aser 11", "23434334", "45123123", "434234324", "test@test.com"));
    app.getContactHelper().submitContactCreation();
  }


}
