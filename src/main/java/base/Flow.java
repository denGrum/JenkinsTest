package base;

import lombok.SneakyThrows;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public interface Flow {

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
}
