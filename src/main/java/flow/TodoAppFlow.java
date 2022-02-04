package flow;

import base.BrowserActions;
import base.Flow;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.TodoAppPage;

public class TodoAppFlow implements Flow, BrowserActions<TodoAppFlow> {

  @Step("Проверка загрузки страницы Todo App")
  public TodoAppFlow assertPageLoaded(String expectedHeader) {
    WebElement element = page(TodoAppPage.class).getHeader();
    Assert.assertTrue(element.isDisplayed() && element.getText().equals(expectedHeader));
    return this;
  }

  @Step("Клик по всем чекбоксам на странице")
  public TodoAppFlow clickOnCheckboxes() {
    page(TodoAppPage.class)
        .getCheckboxes()
        .forEach(
            element -> {
              Assert.assertTrue(element.isDisplayed() && element.isEnabled());
              element.click();
            });
    return this;
  }

  @Step("Проверка оставшегося количества пустых чекбоксов")
  public TodoAppFlow chekRemainingTextField(String remainingText) {
    WebElement element = page(TodoAppPage.class).getRemainingTextField();
    Assert.assertTrue(element.isDisplayed() && element.getText().equals(remainingText));
    return this;
  }

  @Step("Ввод текста в поле")
  public TodoAppFlow fillTextInInputField(String sendableText) {
    WebElement element = page(TodoAppPage.class).getInputTextField();
    Assert.assertTrue(element.isDisplayed() && element.isEnabled());
    element.sendKeys(sendableText);
    return this;
  }

  @Step("Клик по кнопке 'add'")
  public TodoAppFlow clickOnAddButton() {
    WebElement element = page(TodoAppPage.class).getAddButton();
    Assert.assertTrue(element.isDisplayed() && element.isEnabled());
    element.click();
    return this;
  }

  @Step("Проверка текста добаленного чекбокса")
  public TodoAppFlow assertAddedCheckboxTextField(String expectedText) {
    WebElement element = page(TodoAppPage.class).getAddedCheckbox();
    Assert.assertTrue(element.isDisplayed() && element.getText().equals(expectedText));
    return this;
  }

  @Override
  public String goToFlow() {
    return page(TodoAppPage.class).getUrl();
  }
}
