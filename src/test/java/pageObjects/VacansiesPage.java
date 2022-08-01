package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class VacansiesPage extends Page {
  @FindBy(how = How.ID,using = "menu-item-5079")
  public WebElement vacQA;
  @FindBy(how = How.XPATH,using = "*//span[contains(text(), 'Send us')]")
  public WebElement sendCV;
  @FindBy(how = How.XPATH,using = "//div[contains(@class,'wysiwyg wysiwyg-2') and contains(.//p, 'Test Automation Engineers')]/child::ul[1]/li")
  public List<WebElement> qaSkills;
 
  public String qaURL = "https://ctco.lv/careers/vacancies/test-automation-engineer-3/";
  public String vacanciesPageURL = "https://ctco.lv/careers/vacancies/";
  //initializing web driver from Page class
  public VacansiesPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }
  
}
