package co.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by natan.radostin on 2/17/2018.
 */
public class NavigationManager extends HelperBase {

  public NavigationManager(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    if(isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))){
      return;
    }

      click(By.linkText("groups"));

  }
  public void homePage(){
    if(isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }
}
