package com.solvd;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.solvd.pages.HomePage;
import com.solvd.pages.SearchPage;

//Implementation of Web Automation Java Task 1
public class SimpleWebAutomationTest {
    static final Logger logger = LoggerFactory.getLogger(SimpleWebAutomationTest.class);

    WebDriver driver;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--auto-open-devtools-for-tabs");
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @Test
    public void displayMainMenuTest() {
        HomePage startingHomePage = new HomePage(driver);
        startingHomePage.navigateToHomePage();

        startingHomePage.hoverOverHomeButton();
        Assert.assertTrue(startingHomePage.isHomeMenuVisible(), "Failed to display main menu");
    }

    @Test
    public void searchForProductsTest() {
        HomePage startingHomePage = new HomePage(driver);
        startingHomePage.navigateToHomePage();

        String productName = "bronzer";
        startingHomePage.enterSearchQuery(productName);
        SearchPage searchPage = startingHomePage.clickSearch();
        Assert.assertTrue(searchPage.areAllProductNamesMatch(productName), "Failed to find only searched product");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
