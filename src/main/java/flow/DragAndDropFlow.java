package flow;

import base.Flow;
import io.qameta.allure.Step;
import org.testng.Assert;
import page.DragAndDropPage;

public class DragAndDropFlow implements Flow {

  @Step("Проверка загрузки страницы Drag and Drop")
  public DragAndDropFlow assertPageLoaded(String expectedHeader) {
    Assert.assertEquals(find(page(DragAndDropPage.class).getHeader()).getText(), expectedHeader);
    return this;
  }

  @Step("Перетаскивание draggable квадрата на droppable")
  public DragAndDropFlow dragAndDrop() {
    mouseAction()
        .dragAndDrop(
            find(page(DragAndDropPage.class).getDraggableField()),
            find(page(DragAndDropPage.class).getDroppableField()))
        .build()
        .perform();
    return this;
  }

  @Step("Проверка текста droppable квадрата после перетаскивания")
  public DragAndDropFlow assertDroppableFieldChange(String expectedText) {
    Assert.assertEquals(
        find(page(DragAndDropPage.class).getDroppableField()).getText(), expectedText);
    return this;
  }

  @Override
  public <T extends Flow> String goToFlow() {
    return page(DragAndDropPage.class).getUrl();
  }
}
