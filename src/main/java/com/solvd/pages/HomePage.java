package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HomePage extends AbstractPage {
    @FindBy(css = "a.menu_home")
    WebElement homeButton;

    @FindBy(id = "main_menu")
    WebElement homeMenu;

    @FindBy(id = "filter_keyword")
    WebElement searchInput;

    @FindBy(className = "button-in-search")
    WebElement searchButton;

    private String url;

    public HomePage(WebDriver driver) {
        super(driver);
        Properties properties = new Properties();
        try (FileInputStream inStream = new FileInputStream("application.properties")) {
            properties.load(inStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load application properties");
        }
        url = properties.getProperty("homeUrl");
    }

    public void navigateToHomePage() {
        driver.get(url);
    }

    public void hoverOverHomeButton() {
        hoverOver(homeButton);
    }

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
