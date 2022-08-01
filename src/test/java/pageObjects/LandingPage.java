package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends Page
 {
  @FindBy(how = How.ID, using = "menu-item-127")
  public WebElement careers;
  @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Vacancies')]/parent::li")
  public WebElement vacansies;
  public String landingPageURL="https://ctco.lv/";
  //initializing web driver from Page class
  public LandingPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }
  
}
