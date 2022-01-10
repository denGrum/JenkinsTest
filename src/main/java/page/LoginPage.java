package page;

import base.Page;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class LoginPage implements Page {

  private String Url = BASE_URL + "/login-form.html";

  private By header = By.cssSelector("body h2");

  private By credentialTextFields = By.cssSelector("strong");

  private By loginInputField = By.id("username");

  private By passwordInputField = By.id("password");

  private By loginButton = By.cssSelector("button");

  private By loggedInTextField = By.id("logged-in");
}
