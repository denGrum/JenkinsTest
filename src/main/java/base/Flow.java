package base;

import lombok.SneakyThrows;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public interface Flow {

  <T extends Flow> String goToFlow();

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
