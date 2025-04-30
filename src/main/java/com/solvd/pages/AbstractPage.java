package com.solvd.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPage {
    public static final int TIMEOUT = 2;
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void hoverOver(WebElement element) {
        waitUntilVisible(element, TIMEOUT);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        logger.info("Performed hovering over element: {}", element);
    }

    protected boolean isDisplayed(WebElement element) {
        logger.info("Performing display check for element: {}", element);
        return element.isDisplayed();
    }

    protected void sendKeys(WebElement element, String query) {
        waitUntilVisible(element, TIMEOUT);
        element.sendKeys(query);
        logger.info("Performed sending keys to element: {}", element);
    }

    protected void clickElement(WebElement element) {
        waitUntilVisible(element, TIMEOUT);
        element.click();
        logger.info("Performed element clicking");
    }

    protected String getText(WebElement element) {
        logger.info("Performed text reading");
        waitUntilVisible(element, TIMEOUT);
        return element.getText();
    }

    private void waitUntilVisible(WebElement element, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
