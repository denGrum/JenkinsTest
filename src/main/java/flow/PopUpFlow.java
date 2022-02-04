package flow;

import base.BrowserActions;
import base.Flow;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.PopUpPage;

import static base.Start.getWebDriver;

public class PopUpFlow implements Flow, BrowserActions<PopUpFlow> {

  @Step("Проверка загрузки страницы")
  public PopUpFlow assertPageLoaded(String headerText) {
    WebElement element = page(PopUpPage.class).getPageHeader();
    Assert.assertTrue(element.isDisplayed() && element.getText().equals(headerText));
    return this;
  }

  @Step("Клип по ссылке 'Go To Page 2'")
  public PopUpFlow clickOnSecondPageLink() {
    WebElement element = page(PopUpPage.class).getSecondPageLink();
    Assert.assertTrue(element.isDisplayed() && element.isEnabled());
    element.click();
    return this;
  }

  @Step("Клик по кнопке, вызывающей 'Alert'")
  public PopUpFlow clickOnAlertButton() {
    WebElement element = page(PopUpPage.class).getAlertButton();
    Assert.assertTrue(element.isDisplayed() && element.isEnabled());
    element.click();
    return this;
  }

  @Step("Проверка текста и подтверждение 'Alert'")
  public PopUpFlow checkAlertTextAndConfirm(String alertText) {
    Assert.assertEquals(alertAction().getText(), alertText);
    alertAction().accept();
    return this;
  }

  @Step("Клик по кнопке, вызывающей 'PopUp'")
  public PopUpFlow clickOnPopUpButton() {
    WebElement element = page(PopUpPage.class).getPopUpButton();
    Assert.assertTrue(element.isDisplayed() && element.isEnabled());
    element.click();
    return this;
  }

  @Step("Проверка текста и закрытие 'PopUp'")
  public PopUpFlow checkPopUpTextAndClose(String popUpText) {
    String mainPageHandle = getWebDriver().getWindowHandle();
    for (String windowHandle : getWebDriver().getWindowHandles()) {
      if (!windowHandle.equals(mainPageHandle)) {
        getWebDriver().switchTo().window(windowHandle).close();
      }
    }
    getWebDriver().switchTo().window(mainPageHandle);
    return this;
  }

  @Override
  public String goToFlow() {
    return page(PopUpPage.class).getUrl();
  }
}
