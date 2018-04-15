package co.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

/**
 * Created by natan.radostin on 2/17/2018.
 */
public class ApplicationManager {
  private NavigationManager navigationManager;
  private ContactHelperBase contactHelper;
  WebDriver wd;
  private GroupHelperBase groupHelper;
  private SessionHelperBase sessionHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }


  public void init() {

    if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    }
    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelperBase(wd);
    contactHelper = new ContactHelperBase(wd);
    navigationManager = new NavigationManager(wd);
    sessionHelper = new SessionHelperBase(wd);
    sessionHelper.login("admin", "secret");

  }


  public void stop() {
    wd.quit();
  }

  public GroupHelperBase group() {
    return groupHelper;
  }

  public ContactHelperBase contact() {
    return contactHelper;
  }

  public NavigationManager goTo() {
    return navigationManager;
  }

  public SessionHelperBase getSessionHelper() {
    return sessionHelper;
  }
}
