package pageObjects;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
  protected WebDriver driver = iptests.WebDriverAutoDownload.getDriver("chrome");

	public Page(WebDriver driver) {
		this.driver = driver;
	}
  public void waitForElementToBeClickable(WebElement element) {
    new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(element));
  }
  public boolean isElementPresent(WebElement element) {
    try {
        element.getTagName();
        return true;
    } catch (NoSuchElementException nsee) {
        return false;
    }
  }
  public String getCurrentUrl() {
    return driver.getCurrentUrl();
  }
  public void get(String arg0) {
    driver.get(arg0);
  }
}
