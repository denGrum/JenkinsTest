package end2end;

import base.Start;
import flow.LoginFlow;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static base.Start.closeBrowser;

public class LoginTest {

  private String pageHeader;
  private String loggedInText;
  private List<String> credentials;

  @BeforeMethod(groups = {"all", "login"})
  private void beforeMethod() {
    pageHeader = "Login";
    loggedInText = "You are now logged in!";
    credentials = new ArrayList<>();
  }

  @AfterMethod(groups = {"all", "login"})
  private void afterMethod() {
    closeBrowser();
  }

  @Test(
      description = "TC3. Логин тест",
      groups = {"all", "login"})
  @Description("Проверка работы страницы Логин")
  @Owner("GrumezaDO")
  void loginTest() {

    new Start()
        .goTo(LoginFlow.class)
        .assertPageLoaded(pageHeader)
        .saveCredentials(credentials)
        .fillLogin(credentials)
        .fillPassword(credentials)
        .clickOnLoginButton()
        .assertLoginSuccess(loggedInText);
  }
}
