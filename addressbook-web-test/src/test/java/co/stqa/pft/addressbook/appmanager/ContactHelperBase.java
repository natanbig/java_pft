package co.stqa.pft.addressbook.appmanager;

import co.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ContactHelperBase extends HelperBase {
  private boolean acceptNextAlert = true;

  public ContactHelperBase(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMidleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompanyName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomeTelephone());
    type(By.name("mobile"), contactData.getMobileTelephone());
    type(By.name("work"), contactData.getWorkTelephone());
    type(By.name("email"), contactData.getEmail());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void modifyContact(int index, ContactData contact) {
    initiateContactModification(index);
    fillContactForm(contact, false);
    submitContactModification();
    returnToHomePage();
  }


  public void initiateContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    //wd.findElement(By.xpath("//input[@value='Delete']")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
  }

  public void selectContact(int index)  {

    if (!wd.findElement(By.xpath("(//input[@name='selected[]'])[" + (index + 1) + "]")).isSelected()) {
      click(By.xpath("(//input[@name='selected[]'])[" + (index + 1) + "]"));

    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = wd.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

  public void goToContactPage() {
    click(By.linkText("home"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void initiateContactModification(int p) {
    click((By.xpath("(//img[@alt='Edit'])[" + (p + 1) + "]")));
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void create(ContactData contactData, boolean creation) {
    initiateContactCreation();
    fillContactForm(contactData,creation);
    submitContactCreation();
    returnToHomePage();
  }

  public boolean isThereContact(int index) {
    return isElementPresent(By.xpath("(//input[@name='selected[]'])[" + (index + 1) + "]"));
  }


  public int getContactsCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void delete(int p) {
    selectContact(p);
    deleteSelectedContacts();
    returnToHomePage();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elementsID=wd.findElements(By.cssSelector("td:nth-child(1)"));
    List<WebElement> elementsLastName = wd.findElements(By.cssSelector("td:nth-child(2)"));
    List<WebElement> elementsFirstName = wd.findElements(By.cssSelector("td:nth-child(3)"));
    List<WebElement> elementsAddress = wd.findElements(By.cssSelector("td:nth-child(4)"));
    for(int i=0;i<elementsAddress.size();i++){
      int id = Integer.parseInt(elementsID.get(i).findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id,elementsFirstName.get(i).getText(),null,elementsLastName.get(i).getText(),null,null,elementsAddress.get(i).getText(),null,null,null,null,null);
      contacts.add(contact);
    }

    return contacts;
  }
}
