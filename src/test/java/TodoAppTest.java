import base.Start;
import flow.TodoAppFlow;
import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TodoAppTest {

  private String pageHeader;
  private String remainingText;
  private String text;

  @BeforeMethod
  private void beforeMethod() {
    pageHeader = "Todo App";
    remainingText = "0 of 5 remaining";
    text = "Тестове словосочетание";
  }

  @AfterMethod
  private void afterMethod() {
    Start.closeBrowser();
  }

  @Test(
      description = "TC2. Туду-Апп тест",
      groups = {"all"})
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
