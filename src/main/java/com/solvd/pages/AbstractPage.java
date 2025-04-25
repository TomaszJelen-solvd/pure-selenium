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
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void hoverOver(WebElement element) {
        waitUntilVisible(element);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        logger.info("Performed hovering");
    }


    protected boolean isDisplayed(WebElement element) {
        logger.info("Performing display check for element: {}", element);
        return element.isDisplayed();
    }

    protected void sendKeys(WebElement element, String query) {
        waitUntilVisible(element);
        element.sendKeys(query);
        logger.info("Performed sending keys");
    }

    protected void clickElement(WebElement element) {
        waitUntilVisible(element);
        element.click();
        logger.info("Performed element clicking");
    }

    protected String getText(WebElement element) {
        logger.info("Performed text reading");
        waitUntilVisible(element);
        return element.getText();
    }

    private void waitUntilVisible(WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> ExpectedConditions.visibilityOf(element));
    }
}
