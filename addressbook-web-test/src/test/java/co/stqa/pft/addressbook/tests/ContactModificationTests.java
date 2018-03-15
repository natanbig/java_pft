package co.stqa.pft.addressbook.tests;

import co.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

/**
 * Created by natan.radostin on 2/18/2018.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    app.getNavigationManager().gotoHomePage();
    if(!app.getContactHelper().isThereContact(0)){
      app.getContactHelper().createContact(new ContactData("test1", "test2", "test3", "ttt", "dddd", "test1", "23434334", "45123123", "434234324", "test@test.com", "test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initiateContactModification(before.size()-1);
    ContactData contact = new ContactData(before.get(before.size()-1).getId(),"test1","test2","test3","sdasdasdsad",null,"aser 11",null,null,null,null,null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData>  after =app.getContactHelper().getContactList();
    before.remove(before.size()-1);
    before.add(contact);
    Assert.assertEquals(after.size(),before.size());
    Assert.assertEquals(new HashSet<Object>(after),new HashSet<Object>(before));



  }
}
