package page;

import base.Page;
import base.Start;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class HoverPage implements Page {

  private String Url = BASE_URL + "/hover-menu.html";

  @FindBy(css = "div.home>p:nth-of-type(1)")
  private WebElement header;

  @FindBy(css = "li.dropdown>a")
  private WebElement dropdownLink;

  @FindBy(css = "li.secondary-dropdown>a")
  private WebElement secondaryMenuLink;

  @FindBy(css = "ul.secondary")
  private WebElement secondaryActionLink;

  @FindBy(css = "div.secondary-clicked>h1")
  private WebElement changedPageHeader;

  {
    PageFactory.initElements(Start.getWebDriver(), this);
  }
}
