package flow;

import base.Flow;
import io.qameta.allure.Step;
import org.testng.Assert;
import page.TodoAppPage;

public class TodoAppFlow implements Flow {

  @Step("Проверка загрузки страницы Todo App")
  public TodoAppFlow assertPageLoaded(String expectedHeader) {
    Assert.assertEquals(element(page(TodoAppPage.class).getHeader()).getText(), expectedHeader);
    return this;
  }

  @Step("Клик по всем чекбоксам на странице")
  public TodoAppFlow clickOnCheckboxes() {
    elements(page(TodoAppPage.class).getCheckboxes()).forEach(element -> element.click());
    return this;
  }

  @Step("Проверка оставшегося количества пустых чекбоксов")
  public TodoAppFlow chekRemainingTextField(String remainingText) {
    Assert.assertTrue(
        element(page(TodoAppPage.class).getRemainingTextField()).getText().contains(remainingText));
    return this;
  }

  @Step("Ввод текста в поле")
  public TodoAppFlow fillTextInInputField(String text) {
    element(page(TodoAppPage.class).getInputField()).sendKeys(text);
    return this;
  }

  @Step("Клик по кнопке 'add'")
  public TodoAppFlow clickOnAddButton() {
    element(page(TodoAppPage.class).getAddButton()).click();
    return this;
  }

  @Step("Проверка текста добаленного чекбокса")
  public TodoAppFlow assertAddedCheckboxTextField(String expectedText) {
    Assert.assertTrue(
        element(page(TodoAppPage.class).getAddedCheckbox()).getText().contains(expectedText));
    return this;
  }

  @Override
  public <T extends Flow> String goToFlow() {
    return page(TodoAppPage.class).getUrl();
  }
}
