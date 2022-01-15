package page;

import base.Page;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class DragAndDropPage implements Page {

  private String Url = BASE_URL + "/drag-and-drop.html";

  @FindBy(css = "body>h1")
  private WebElement header;

  @FindBy(id = "draggable")
  private WebElement draggableField;

  @FindBy(id = "droppable")
  private WebElement droppableField;
}
