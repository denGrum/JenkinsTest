package page;

import base.Page;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class DragAndDropPage implements Page {

  private String Url = Page.BASE_URL + "/drag-and-drop.html";

  private By header = By.cssSelector("body>h1");

  private By draggableField = By.id("draggable");

  private By droppableField = By.id("droppable");
}
