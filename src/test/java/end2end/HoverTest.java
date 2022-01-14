package end2end;

import base.Start;
import flow.HoverFlow;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import lombok.SneakyThrows;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static base.Start.closeBrowser;

public class HoverTest {

  private String pageHeader;
  private String changedPageHeader;

  @BeforeMethod(alwaysRun = true)
  private void beforeMethod() {
    pageHeader = "Welcome. This is a test page for menu hovers with selenium test.";
    changedPageHeader = "Secondary Page";
  }

  @AfterMethod(alwaysRun = true)
  private void afterMethod() {
    closeBrowser();
  }

  @Test(
      description = "TC4. Ховер тест",
      groups = {"all", "hover"})
  @Description("Проверка работы страницы Ховер")
  @Owner("GrumezaDO")
  void hoverTest() {

    new Start()
        .goTo(HoverFlow.class)
        .assertPageLoaded(pageHeader)
        .hoverDropdownLink()
        .hoverSecondaryMenuLink()
        .clickOnSecondaryActionLink()
        .assertPageHeaderChanged(changedPageHeader);
  }
}
