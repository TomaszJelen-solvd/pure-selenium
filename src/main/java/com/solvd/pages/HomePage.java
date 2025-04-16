package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(css = "a[class*='menu_home'][class*='active']")
    WebElement homeButton;

    @FindBy(id = "main_menu")
    WebElement homeMenu;

    @FindBy(id = "filter_keyword")
    WebElement searchInput;

    @FindBy(className = "button-in-search")
    WebElement searchButton;

    public HomePage(WebDriver driver) {
        driver.get("https://automationteststore.com/");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverOverHomeButton() {
        Actions action = new Actions(driver);
        action.moveToElement(homeButton).perform();
    }

    public boolean isHomeMenuVisible() {
        return homeMenu.isDisplayed();
    }

    public void fillSearch(String fill) {
        searchInput.sendKeys(fill);
    }

    public SearchPage clickSearch() {
        searchButton.click();
        return new SearchPage(driver);
    }
}
