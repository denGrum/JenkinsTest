package page;

import base.Page;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class TodoAppPage implements Page {

  private String Url = BASE_URL + "/todo-app.html";

  private By header = By.cssSelector("h2");

  private By checkboxes = By.cssSelector("input[type='checkbox']");

  private By remainingTextField = By.cssSelector(".ng-binding");

  private By inputField = By.cssSelector("input[type='text']");

  private By addButton = By.id("addbutton");

  private By addedCheckbox = By.cssSelector(".done-false");
}
