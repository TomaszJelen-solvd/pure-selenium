package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage{
    @FindBy(css = "a.menu_home")
    WebElement homeButton;

    @FindBy(id = "main_menu")
    WebElement homeMenu;

    @FindBy(id = "filter_keyword")
    WebElement searchInput;

    @FindBy(className = "button-in-search")
    WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        driver.get("https://automationteststore.com/");
    }

    public void hoverOverHomeButton() { hoverOver(homeButton); }

    public boolean isHomeMenuVisible() {
        return isDisplayed(homeMenu);
    }

    public void enterSearchQuery(String query) {
        sendKeys(searchInput, query);
    }


    public SearchPage clickSearch() {
        clickElement(searchButton);
        return new SearchPage(driver);
    }


}
