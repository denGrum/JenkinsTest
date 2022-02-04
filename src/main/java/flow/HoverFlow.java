package flow;

import base.BrowserActions;
import base.Flow;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.HoverPage;

public class HoverFlow implements Flow, BrowserActions<HoverFlow> {

  @Step("Проверка загрузки страницы")
  public HoverFlow assertPageLoaded(String header) {
    WebElement element = page(HoverPage.class).getHeader();
    Assert.assertTrue(element.isDisplayed() && element.getText().equals(header));
    return this;
  }

  @Step("Наверсти курсор на ссылку 'Dropdown'")
  public HoverFlow hoverDropdownLink() {
    WebElement element = page(HoverPage.class).getDropdownLink();
    Assert.assertTrue(element.isDisplayed());
    mouseAction().moveToElement(element).build().perform();
    return this;
  }

  @Step("Навести курсор на ссылку 'Secondary Menu'")
  public HoverFlow hoverSecondaryMenuLink() {
    WebElement element = page(HoverPage.class).getSecondaryMenuLink();
    Assert.assertTrue(element.isDisplayed());
    mouseAction().moveToElement(element).build().perform();
    return this;
  }

  @Step("Клик по ссылке 'Secondary Action'")
  public HoverFlow clickOnSecondaryActionLink() {
    WebElement element = page(HoverPage.class).getSecondaryActionLink();
    Assert.assertTrue(element.isDisplayed());
    element.click();
    return this;
  }

  @Step("Проверка изменения заголовка страницы")
  public HoverFlow assertPageHeaderChanged(String changedHeader) {
    WebElement element = page(HoverPage.class).getChangedPageHeader();
    Assert.assertTrue(element.isDisplayed() && element.getText().equals(changedHeader));
    return this;
  }

  @Override
  public String goToFlow() {
    return page(HoverPage.class).getUrl();
  }
}
