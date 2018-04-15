package co.stqa.pft.addressbook.tests;

import co.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

/**
 * Created by natan.radostin on 2/18/2018.
 */
public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if(app.contact().list().size()==0){
      app.contact().create(new ContactData("test1", "test2", "test3", "ttt", "dddd", "test1", "23434334", "45123123", "434234324", "test@test.com", "test1"), true);
    }
  }
  @Test
  public void testContactModification(){

    List<ContactData> before = app.contact().list();
    int index = before.size()-1;
    ContactData contact = new ContactData(before.get(index).getId(),"test1","test2","test3","sdasdasdsad",null,"aser 11",null,null,null,null,null);
    app.contact().modifyContact(index, contact);
    List<ContactData>  after =app.contact().list();
    before.remove(index);
    before.add(contact);
    Assert.assertEquals(after.size(),before.size());
    Assert.assertEquals(new HashSet<Object>(after),new HashSet<Object>(before));



  }


}
