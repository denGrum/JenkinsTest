import base.Start;
import flow.DragAndDropFlow;
import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTest {

  private String pageHeader;
  private String dropResultText;

  @BeforeMethod
  private void beforeMethod() {
    pageHeader = "Drag and Drop example for Selenium Tests";
    dropResultText = "Dropped!";
  }

  @AfterMethod
  private void afterMethod() {
    Start.closeBrowser();
  }

  @Test(
      description = "TC1. Драг-Энд-Дроп тест",
      groups = {"all"})
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
