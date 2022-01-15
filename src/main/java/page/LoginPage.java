package page;

import base.Page;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class LoginPage implements Page {

  private String Url = BASE_URL + "/login-form.html";

  @FindBy(css = "body h2")
  private WebElement header;

  @FindBy(css = "strong")
  private List<WebElement> credentialTextFields;

  @FindBy(id = "username")
  private WebElement loginInputField;

  @FindBy(id = "password")
  private WebElement passwordInputField;

  @FindBy(css = "button")
  private WebElement loginButton;

  @FindBy(id = "logged-in")
  private WebElement loggedInTextField;
}
