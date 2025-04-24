package com.solvd;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTest {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    protected WebDriver driver() {
        WebDriver driver = drivers.get();
        if (driver == null) {
            throw new IllegalStateException("Driver should have not been null.");
        }
        return driver;
    }

    @BeforeMethod
    public void beforeEachTest() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--auto-open-devtools-for-tabs");
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        drivers.set(driver);
        logger.info("Driver created");
    }

    @AfterMethod
    public void afterEachTest() {
        driver().quit();
        logger.info("Driver destroyed");
    }

}
