package flow;

import base.Flow;
import base.Start;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.PopUpPage;

public class PopUpFlow implements Flow<PopUpFlow> {

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
    String mainPageHandle = Start.getWebDriver().getWindowHandle();
    for (String windowHandle : Start.getWebDriver().getWindowHandles()) {
      if (!windowHandle.equals(mainPageHandle)) {
        Start.getWebDriver().switchTo().window(windowHandle);
      }
    }
    WebElement element = page(PopUpPage.class).getPopUpTextField();
    Assert.assertTrue(element.isDisplayed());
    Assert.assertEquals(popUpText, element.getText());
    browserCloseWindow();
    Start.getWebDriver().switchTo().window(mainPageHandle);
    return this;
  }

  @Override
  public String goToFlow() {
    return page(PopUpPage.class).getUrl();
  }
}
