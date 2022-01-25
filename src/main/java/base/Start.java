package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Start {

  private static WebDriver webDriver;

  public Start() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options
        .setHeadless(false)
        .setImplicitWaitTimeout(Duration.ofSeconds(20))
        .addArguments("--window-size=1920,1080");
    webDriver = new ChromeDriver(options);
  }

  public static void closeBrowser() {
    webDriver.quit();
  }

  public static WebDriver getWebDriver() {
    return webDriver;
  }

  @SneakyThrows
  public <T extends Flow> T goTo(Class<T> cls) {
    T t = cls.getDeclaredConstructor().newInstance();
    webDriver.get(t.goToFlow());
    return t;
  }
}
