package end2end;

import base.Start;
import flow.TodoAppFlow;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static base.Start.closeBrowser;

public class TodoAppTest {

  private String pageHeader;
  private String remainingText;
  private String text;

  @BeforeMethod(groups = {"all", "todoApp"})
  private void beforeMethod() {
    pageHeader = "Todo App";
    remainingText = "0 of 5 remaining";
    text = "Тестове словосочетание";
  }

  @AfterMethod(groups = {"all", "todoApp"})
  private void afterMethod() {
    closeBrowser();
  }

  @Test(
      description = "TC2. Туду-Апп тест",
      groups = {"all", "todoApp"})
  @Description("Проверка работы страницы Туду-Апп")
  @Owner("GrumezaDO")
  void todoAppTest() {

    new Start()
        .goTo(TodoAppFlow.class)
        .assertPageLoaded(pageHeader)
        .clickOnCheckboxes()
        .chekRemainingTextField(remainingText)
        .fillTextInInputField(text)
        .clickOnAddButton()
        .assertAddedCheckboxTextField(text);
  }
}
