package base;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public interface Flow {

  <T extends Flow> String goToFlow();

  default WebElement element(By locator) {
    return Start.getWebDriver().findElement(locator);
  }

  default List<WebElement> elements(By locator) {
    return Start.getWebDriver().findElements(locator);
  }

  default Actions mouseAction() {
    return new Actions(Start.getWebDriver());
  }

  @SneakyThrows
  default <E extends Page> E page(Class<E> cls) {
    E page = cls.getConstructor().newInstance();
    PageFactory.initElements(Start.getWebDriver(), page);
    return page;
  }
}
