package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(css = "a[class='active menu_home']")
    WebElement homeButton;

    @FindBy(css = "ul[id='main_menu']")
    WebElement homeMenu;

    public HomePage(WebDriver driver) {
        driver.get("https://automationteststore.com/");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverHome() {
        Actions action = new Actions(driver);
        action.moveToElement(homeButton).perform();
    }

    public boolean isHomeMenuVisible() {
        return homeMenu.isDisplayed();
    }
}
