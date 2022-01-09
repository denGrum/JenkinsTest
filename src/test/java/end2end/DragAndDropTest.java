package end2end;

import base.Start;
import flow.DragAndDropFlow;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static base.Start.closeBrowser;

public class DragAndDropTest {

  private String pageHeader;
  private String dropResultText;

  @BeforeMethod(groups = {"all","not"})
  private void beforeMethod() {
    pageHeader = "Drag and Drop example for Selenium Tests";
    dropResultText = "Dropped!";
  }

  @AfterMethod(groups = {"all","not"})
  private void afterMethod() {
    closeBrowser();
  }

  @Test(
      description = "TC1. Драг-Энд-Дроп тест",
      groups = {"all","not"})
  @Description("Проверка работы страницы Драг-Энд-Дроп")
  @Owner("GrumezaDO")
  void dragAndDropTest() {

    new Start()
        .goTo(DragAndDropFlow.class)
        .assertPageLoaded(pageHeader)
        .dragAndDrop()
        .assertDroppableFieldChange(dropResultText);
  }
}
