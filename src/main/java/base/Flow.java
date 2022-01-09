package base;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public interface Flow {

  <T extends Flow> String goToFlow();

  default WebElement find(By locator) {
    return Start.getWebDriver().findElement(locator);
  }

  default Actions mouseAction() {
    return new Actions(Start.getWebDriver());
  }

  @SneakyThrows
  default <E extends Page> E page(Class<E> cls) {
    return cls.getConstructor().newInstance();
  }
}
