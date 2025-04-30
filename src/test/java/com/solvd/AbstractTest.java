package com.solvd;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import com.solvd.util.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

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

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        WebDriver driver = null;
        try {
            Properties properties = PropertiesLoader.getProperties();
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("--auto-open-devtools-for-tabs");
                driver = new RemoteWebDriver(new URL(properties.getProperty("driverUrl")), chromeOptions);

            } else if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--kiosk");
//                firefoxOptions.addArguments("--auto-open-devtools-for-tabs");
                driver = new RemoteWebDriver(new URL(properties.getProperty("driverUrl")), firefoxOptions);
            }
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
