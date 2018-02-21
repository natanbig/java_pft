package co.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by natan.radostin on 2/17/2018.
 */
public class SessionHelperBase extends HelperBase {

  public SessionHelperBase(WebDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {
    type(By.name("user"),username);
    type(By.name("pass"),password);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }
}
