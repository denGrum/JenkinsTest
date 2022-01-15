package page;

import base.Page;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class TodoAppPage implements Page {

  private String Url = BASE_URL + "/todo-app.html";

  @FindBy(css = "h2")
  private WebElement header;

  @FindBy(css = "input[type='checkbox']")
  private List<WebElement> checkboxes;

  @FindBy(css = "div.well>span")
  private WebElement remainingTextField;

  @FindBy(css = "input[type='text']")
  private WebElement inputTextField;

  @FindBy(id = "addbutton")
  private WebElement addButton;

  @FindBy(css = ".done-false")
  private WebElement addedCheckbox;
}
