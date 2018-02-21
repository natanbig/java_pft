package co.stqa.pft.addressbook.tests;

import co.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

/**
 * Created by natan.radostin on 2/18/2018.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    app.getNavigationManager().gotoHomePage();
    app.getContactHelper().selectContact(1);
    app.getContactHelper().initiateContactModification(1);
    app.getContactHelper().fillContactForm(new ContactData("mod123","seeeee","sqebbbasd","sdasdasdsad",null,null,null,null,null,null,null), false);
    app.getGroupHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();

  }
}
