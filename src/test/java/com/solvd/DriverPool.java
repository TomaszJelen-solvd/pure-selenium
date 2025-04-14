package com.solvd;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverPool {
    private static DriverPool driverPool;
    private List<WebDriver> availableDrivers;

    private DriverPool() {
        availableDrivers = new ArrayList<>();
    }

    public static DriverPool getDriverPool() {
        if (driverPool == null) {
            driverPool = new DriverPool();
        }
        return driverPool;
    }

    public WebDriver getDriver() throws MalformedURLException, InterruptedException {
        synchronized (this) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("--auto-open-devtools-for-tabs");
                WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                return driver;
        }
    }

    public void releaseDriver(WebDriver driver) throws InterruptedException {
        synchronized (this) {
            availableDrivers.add(driver);
        }
    }

    public void close() {
        availableDrivers.stream()
                .forEach(WebDriver::quit);
    }
}
