package flow;

import base.Flow;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.LoginPage;

import java.util.List;

public class LoginFlow implements Flow {

  @Step("Проверка загрузки страницы Логин")
  public LoginFlow assertPageLoaded(String expectedHeader) {
    WebElement element = element(page(LoginPage.class).getHeader());
    Assert.assertTrue(element.isDisplayed() && element.getText().equals(expectedHeader));
    return this;
  }

  @Step("Сохранение пароль и логин для последующей авторизации")
  public LoginFlow saveCredentials(List<String> credentials) {
    elements(page(LoginPage.class).getCredentialTextFields())
        .forEach(element -> credentials.add(element.getText()));
    return this;
  }

  @Step("Ввод логина")
  public LoginFlow fillLogin(List<String> credentials) {
    WebElement element = element(page(LoginPage.class).getLoginInputField());
    Assert.assertTrue(element.isDisplayed());
    element.sendKeys(credentials.get(0));
    return this;
  }

  @Step("Ввод пароля")
  public LoginFlow fillPassword(List<String> credentials) {
    WebElement element = element(page(LoginPage.class).getPasswordInputField());
    Assert.assertTrue(element.isDisplayed());
    element.sendKeys(credentials.get(1));
    return this;
  }

  @Step("Клик по кнопке Логин")
  public LoginFlow clickOnLoginButton() {
    WebElement element = element(page(LoginPage.class).getLoginButton());
    Assert.assertTrue(element.isDisplayed() && element.isEnabled());
    element.click();
    return this;
  }

  @Step("Проверка успешности авторизации")
  public LoginFlow assertLoginSuccess(String loggedInText) {
    WebElement element = element(page(LoginPage.class).getLoggedInTextField());
    Assert.assertTrue(element.isDisplayed() && element.getText().equals(loggedInText));
    return this;
  }

  @Override
  public <T extends Flow> String goToFlow() {
    return page(LoginPage.class).getUrl();
  }
}
