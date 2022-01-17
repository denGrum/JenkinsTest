package base;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public interface Flow<U> {

  String goToFlow();

  @SneakyThrows
  default <E extends Page> E page(Class<E> cls) {
    E page = cls.getConstructor().newInstance();
    PageFactory.initElements(Start.getWebDriver(), page);
    return page;
  }

  default Actions mouseAction() {
    return new Actions(Start.getWebDriver());
  }

  default Alert alertAction() {
    return new WebDriverWait(Start.getWebDriver(), Duration.ofSeconds(5))
        .until(ExpectedConditions.alertIsPresent());
  }

  @Step("Переход на предыдущую страницу")
  default U browserBack() {
    Start.getWebDriver().navigate().back();
    return (U) this;
  }

  @Step("Переход на последующую страницу")
  default U browserForward() {
    Start.getWebDriver().navigate().forward();
    return (U) this;
  }

  @Step("Обновление страницы")
  default U browserRefresh() {
    Start.getWebDriver().navigate().refresh();
    return (U) this;
  }

  @Step("Закрытие окна браузера")
  default U browserCloseWindow() {
    Start.getWebDriver().close();
    return (U) this;
  }

  @Step("Ожидание")
  @SneakyThrows
  default U browserSleep(long timeForWaiting) {
    try {
      Thread.sleep(timeForWaiting);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(ex);
    }
    return (U) this;
  }
}
