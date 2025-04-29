package com.solvd;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

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

    protected WebDriver getDriver() {
        WebDriver driver = drivers.get();
        if (driver == null) {
            throw new IllegalStateException("Driver for thread: " + Thread.currentThread().getId() + " should have not been null.");
        }
        return driver;
    }

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--auto-open-devtools-for-tabs");
        WebDriver driver = null;
        try {
            Properties properties = new Properties();
            try (FileInputStream inStream = new FileInputStream("application.properties")) {
                properties.load(inStream);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load application properties");
            }
            driver = new RemoteWebDriver(new URL(properties.getProperty("driverUrl")), options);
        } catch (MalformedURLException e) {
            logger.info("Failed to create WebDriver for thread: {}", Thread.currentThread().getId());
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        drivers.set(driver);
        logger.info("WebDriver created for thread: {}", Thread.currentThread().getId());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        getDriver().quit();
        logger.info("WebDriver quit for thread: {}", Thread.currentThread().getId());
    }

}
