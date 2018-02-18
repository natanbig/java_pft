package co.stqa.pft.addressbook.appmanager;

import co.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by natan.radostin on 2/17/2018.
 */
public class ContactHelper extends BaseHelper {


  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"),contactData.getFirstName());
    type(By.name("middlename"),contactData.getMidleName());
    type(By.name("lastname"),contactData.getLastName());
    type(By.name("title"),contactData.getTitle());
    type(By.name("company"),contactData.getCompanyName());
    type(By.name("address"),contactData.getAddress());
    type(By.name("home"),contactData.getHomeTelephone());
    type(By.name("mobile"),contactData.getMobileTelephone());
    type(By.name("work"),contactData.getWorkTelephone());
    type(By.name("email"),contactData.getEmail());
  }

  public void initiateContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void deleteSelectedContacts() {
      click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContact(int index) {
      if (!wd.findElement(By.xpath("(//input[@name='selected[]'])[" + (index+1) + "]")).isSelected()) {
          click(By.xpath("(//input[@name='selected[]'])[" + (index+1) + "]"));
      }
  }

  public void goToContactPage() {
      click(By.linkText("home"));
  }
}
