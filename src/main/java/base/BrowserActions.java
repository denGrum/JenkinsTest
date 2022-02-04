package base;

import io.qameta.allure.Step;
import lombok.SneakyThrows;

public interface BrowserActions<E> {

  @Step("Переход на предыдущую страницу")
  default E browserBack() {
    Start.getWebDriver().navigate().back();
    return (E) this;
  }

  @Step("Переход на последующую страницу")
  default E browserForward() {
    Start.getWebDriver().navigate().forward();
    return (E) this;
  }

  @Step("Обновление страницы")
  default E browserRefresh() {
    Start.getWebDriver().navigate().refresh();
    return (E) this;
  }

  @Step("Закрытие окна браузера")
  default E browserCloseWindow() {
    Start.getWebDriver().close();
    return (E) this;
  }

  @Step("Ожидание")
  @SneakyThrows
  default E browserSleep(long timeForWaiting) {
    try {
      Thread.sleep(timeForWaiting);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(ex);
    }
    return (E) this;
  }
}
