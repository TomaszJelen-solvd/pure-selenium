package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(css = "a.menu_home")
    WebElement homeButton;

    @FindBy(id = "main_menu")
    WebElement homeMenu;

    @FindBy(id = "filter_keyword")
    WebElement searchInput;

    @FindBy(className = "button-in-search")
    WebElement searchButton;

    public HomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.get("https://automationteststore.com/");
    }

    public void hoverOverHomeButton() {
        Actions action = new Actions(driver);
        action.moveToElement(homeButton).perform();
    }

    public boolean isHomeMenuVisible() {
        return homeMenu.isDisplayed();
    }

    public void enterSearchQuery(String query) {
        searchInput.sendKeys(query);
    }

    public SearchPage clickSearch() {
        searchButton.click();
        return new SearchPage(driver);
    }
}
