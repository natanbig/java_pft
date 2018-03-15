package co.stqa.pft.addressbook.tests;

import co.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {




  @Test
  public void testContactCreation() {
    app.getNavigationManager().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("test1", "test2", "test3", "ttt", "dddd", "aser 11", "23434334", "45123123", "434234324", "test@test.com", "test1");
    app.getContactHelper().createContact(contact, true);
    List<ContactData> after =app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()+1);
//    int max=0;
//    for(ContactData c:after){
//      if(c.getId()>max)
//        max=c.getId();
//    }
//    contact.setId(max);
    //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId= (Comparator<ContactData>) (o1, o2) -> Integer.compare(o1.getId(),o2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after,before);
  }


}
