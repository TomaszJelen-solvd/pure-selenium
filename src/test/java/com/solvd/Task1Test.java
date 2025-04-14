package com.solvd;

import com.solvd.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Task1Test {
    static final Logger logger = LoggerFactory.getLogger(Task1Test.class);

    DriverPool driverPool;

    @BeforeTest
    public void beforeTest() {
        driverPool = DriverPool.getDriverPool();
    }

    @Test
    public void mainMenuSeleniumTest() throws MalformedURLException, InterruptedException {

        WebDriver driver = driverPool.getDriver();

        HomePage startingHomePage = new HomePage(driver);

        startingHomePage.hoverHome();
        Assert.assertTrue(startingHomePage.isHomeMenuVisible(), "Failed to display main menu");

        driverPool.releaseDriver(driver);
    }

    @AfterTest
    public void afterTest() {
        driverPool.close();
    }
}
