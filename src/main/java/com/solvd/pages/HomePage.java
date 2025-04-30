package com.solvd.pages;

import com.solvd.Main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.List;

public class HomePage extends AbstractPage {
    @FindBy(css = "a.menu_home")
    WebElement homeButton;

    @FindBy(id = "main_menu")
    WebElement homeMenu;

    @FindBy(xpath = "//a[text()='Login or register']")
    WebElement loginButton;


    @FindBy(id = "filter_keyword")
    WebElement searchInput;

    @FindBy(className = "button-in-search")
    WebElement searchButton;

    @FindBy(className = "block_7")
    WebElement cartButton;

    @FindBy(className = "productcart")
    List<WebElement> productNames;


    private String url;

    public HomePage(WebDriver driver) {
        super(driver);
        Properties properties = new Properties();
        try (InputStream inStream = Main.class.getResourceAsStream("/application.properties")) {
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

    public void addProductToCart(int index) {
        clickElement(productNames.get(index));
    }

    public LoginPage clickLogin() {
        clickElement(loginButton);
        return new LoginPage(driver);
    }

    public CartPage clickCart() {
        clickElement(cartButton);
        return new CartPage(driver);
    }

    public SearchPage clickSearch() {
        clickElement(searchButton);
        return new SearchPage(driver);
    }


}
