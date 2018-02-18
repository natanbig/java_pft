package co.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by natan.radostin on 2/17/2018.
 */
public class NavigationManager extends BaseHelper {

  public NavigationManager(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }
  public void gotoHomePage(){
    click(By.linkText("home"));
  }
}
