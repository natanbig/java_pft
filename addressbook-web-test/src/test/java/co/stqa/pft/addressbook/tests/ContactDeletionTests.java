package co.stqa.pft.addressbook.tests;

import co.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if(app.contact().list().size()==0){
            app.contact().create(new ContactData("test1", "test2", "test3", "ttt", "dddd", "test1", "23434334", "45123123", "434234324", "test@test.com", "test1"), true);
        }
    }
    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.contact().list();
        app.contact().delete(0);
        List<ContactData>  after =app.contact().list();
        Assert.assertEquals(after.size()+1,before.size());

    }



}
