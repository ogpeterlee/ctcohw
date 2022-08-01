package iptests;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.LandingPage;
import pageObjects.VacansiesPage;



public class AppTest
{
    //calling function that returns up to date webdriver (currently only chrome or edge)
    WebDriver driver = iptests.WebDriverAutoDownload.getDriver("chrome");
    //defining page objects
    private LandingPage landingPage = new LandingPage(driver);
    private VacansiesPage vacansiesPage = new VacansiesPage(driver);
    @Test
    public void goToPage() {
        landingPage.get(landingPage.landingPageURL);
        landingPage.isElementPresent(landingPage.careers);
        //defining action for driver to hover over careers element
        Actions action = new Actions(driver);
        action.moveToElement(landingPage.careers).perform();
        landingPage.isElementPresent(landingPage.vacansies);
        landingPage.vacansies.click();
        assertEquals(vacansiesPage.vacanciesPageURL, vacansiesPage.getCurrentUrl());
        vacansiesPage.waitForElementToBeClickable(vacansiesPage.vacQA);
        vacansiesPage.vacQA.click();
        assertEquals(vacansiesPage.qaURL, vacansiesPage.getCurrentUrl());
        //waiting for ul containing skills to load
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[contains(text(), 'Professional skills and qualification:')]/parent::p/following-sibling::ul[1]")));
        assertEquals(8, vacansiesPage.qaSkills.size());
    }
    //things to do after test cases
    @After
    public void tearDown(){
    //killing web driver
        driver.quit();
    }
}

