package end2end;

import base.Start;
import flow.PopUpFlow;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static base.Start.closeBrowser;

public class PopUpTest {

  private String mainPageHeader;
  private String secondPageHeader;
  private String alertText;
  private String popUpText;

  @BeforeMethod(alwaysRun = true)
  private void beforeMethod() {
    mainPageHeader = "Selenium Test Example Page";
    secondPageHeader = "Selenium Example Page 2";
    alertText = "Are you sure";
    popUpText = "This is inside the popup window";
  }

  @AfterMethod(alwaysRun = true)
  private void afterMethod() {
    closeBrowser();
  }

  @Test(
      description = "TC5. Поп-Ап тест",
      groups = {"all", "popUp"})
  @Description("Проверка работы страницы Поп-Ап")
  @Owner("GrumezaDO")
  void popUpTest() {

    new Start()
        .goTo(PopUpFlow.class)
        .assertPageLoaded(mainPageHeader)
        .clickOnSecondPageLink()
        .assertPageLoaded(secondPageHeader)
        .browserBack()
        .clickOnAlertButton()
        .checkAlertTextAndConfirm(alertText)
        .clickOnPopUpButton()
        .checkPopUpTextAndClose(popUpText)
        .assertPageLoaded(mainPageHeader)
        .browserSleep(3000);
  }
}
