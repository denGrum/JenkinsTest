package flow;

import base.Flow;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.DragAndDropPage;

public class DragAndDropFlow implements Flow {

  @Step("Проверка загрузки страницы Drag and Drop")
  public DragAndDropFlow assertPageLoaded(String expectedHeader) {
    WebElement element = page(DragAndDropPage.class).getHeader();
    Assert.assertTrue(element.isDisplayed() && element.getText().equals(expectedHeader));
    return this;
  }

  @Step("Перетаскивание draggable квадрата на droppable")
  public DragAndDropFlow dragAndDrop() {
    WebElement dragElement = page(DragAndDropPage.class).getDraggableField();
    WebElement dropElement = page(DragAndDropPage.class).getDroppableField();
    Assert.assertTrue(dragElement.isDisplayed() && dropElement.isDisplayed());
    mouseAction().dragAndDrop(dragElement, dropElement).build().perform();
    return this;
  }

  @Step("Проверка текста droppable квадрата после перетаскивания")
  public DragAndDropFlow assertDroppableFieldChange(String expectedText) {
    WebElement element = page(DragAndDropPage.class).getDroppableField();
    Assert.assertTrue(element.isDisplayed() && element.getText().equals(expectedText));
    return this;
  }

  @Override
  public <T extends Flow> String goToFlow() {
    return page(DragAndDropPage.class).getUrl();
  }
}
