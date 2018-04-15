package co.stqa.pft.addressbook.tests;

import co.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {




  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData("test1", "test2", "test3", "ttt", "dddd", "aser 11", "23434334", "45123123", "434234324", "test@test.com", "test1");
    app.contact().create(contact, true);
    List<ContactData> after =app.contact().list();
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
