package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Start {

  private static WebDriver webDriver;

  public Start() {
    WebDriverManager.chromedriver().setup();
    webDriver = new ChromeDriver();
    webDriver.manage().window().setSize(new Dimension(1920, 1080));
    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }

  public static void closeBrowser() {
    webDriver.quit();
  }

  public static WebDriver getWebDriver() {
    return webDriver;
  }

  @SneakyThrows
  public <T extends Flow> T goTo(Class<T> cls) {
    T t = cls.getConstructor().newInstance();
    webDriver.get(t.goToFlow());
    return t;
  }
}
