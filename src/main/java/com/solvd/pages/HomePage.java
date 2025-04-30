package com.solvd.pages;

import com.solvd.util.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage extends AbstractPage {
    @FindBy(css = "a.menu_home")
    private WebElement homeButton;

    @FindBy(id = "main_menu")
    private WebElement homeMenu;

    @FindBy(xpath = "//a[text()='Login or register']")
    private WebElement loginButton;


    @FindBy(id = "filter_keyword")
    private WebElement searchInput;

    @FindBy(className = "button-in-search")
    private WebElement searchButton;

    @FindBy(className = "block_7")
    private WebElement cartButton;

    @FindBy(className = "productcart")
    private List<WebElement> productNames;

    private String url;

    public HomePage(WebDriver driver) {
        super(driver);
        url = PropertiesLoader.getProperties().getProperty("homeUrl");
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

    public void addSeveralProductsToCart(int index, int quantity) {
        for (int i = 0; i < quantity; i++) {
            addProductToCart(index);
        }
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
