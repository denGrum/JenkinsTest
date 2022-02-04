package flow;

import base.BrowserActions;
import base.Flow;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.LoginPage;

import java.util.List;

public class LoginFlow implements Flow, BrowserActions<LoginFlow> {

  @Step("Проверка загрузки страницы Логин")
  public LoginFlow assertPageLoaded(String expectedHeader) {
    WebElement element = page(LoginPage.class).getHeader();
    Assert.assertTrue(element.isDisplayed() && element.getText().equals(expectedHeader));
    return this;
  }

  @Step("Сохранение пароля и логина для последующей авторизации")
  public LoginFlow saveCredentials(List<String> credentials) {
    page(LoginPage.class)
        .getCredentialTextFields()
        .forEach(
            element -> {
              Assert.assertTrue(element.isDisplayed());
              credentials.add(element.getText());
            });
    return this;
  }

  @Step("Ввод логина")
  public LoginFlow fillLogin(List<String> credentials) {
    WebElement element = page(LoginPage.class).getLoginInputField();
    Assert.assertTrue(element.isDisplayed() && element.isEnabled());
    element.sendKeys(credentials.get(0));
    return this;
  }

  @Step("Ввод пароля")
  public LoginFlow fillPassword(List<String> credentials) {
    WebElement element = page(LoginPage.class).getPasswordInputField();
    Assert.assertTrue(element.isDisplayed() && element.isEnabled());
    element.sendKeys(credentials.get(1));
    return this;
  }

  @Step("Клик по кнопке Логин")
  public LoginFlow clickOnLoginButton() {
    WebElement element = page(LoginPage.class).getLoginButton();
    Assert.assertTrue(element.isDisplayed() && element.isEnabled());
    element.click();
    return this;
  }

  @Step("Проверка успешности авторизации")
  public LoginFlow assertLoginSuccess(String loggedInText) {
    WebElement element = page(LoginPage.class).getLoggedInTextField();
    Assert.assertTrue(element.isDisplayed() && element.getText().equals(loggedInText));
    return this;
  }

  @Override
  public String goToFlow() {
    return page(LoginPage.class).getUrl();
  }
}
