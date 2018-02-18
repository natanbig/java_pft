package co.stqa.pft.addressbook.appmanager;

import co.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created by natan.radostin on 2/17/2018.
 */
public class ApplicationManager {
  private NavigationManager navigationManager;
  private ContactHelper contactHelper;
  FirefoxDriver wd;
  private  GroupHelper groupHelper;
  private  SessionHelper sessionHelper;



  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    contactHelper = new ContactHelper(wd);
    navigationManager = new NavigationManager(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");

  }



  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public NavigationManager getNavigationManager() {
    return navigationManager;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }
}
