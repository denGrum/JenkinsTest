package page;

import base.Page;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class PopUpPage implements Page {

  private String Url = BASE_URL + "/selenium_example_page.html";

  @FindBy(css = "div.container>h2")
  private WebElement pageHeader;

  @FindBy(css = "#link-test>a")
  private WebElement secondPageLink;

  @FindBy(id = "alertid")
  private WebElement alertButton;

  @FindBy(css = "button[onclick='popup()']")
  private WebElement popUpButton;

  @FindBy(css = "body>h4")
  private WebElement popUpTextField;
}
