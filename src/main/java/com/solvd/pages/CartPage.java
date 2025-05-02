package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage{
    @FindBy(xpath = "//td[contains(@Class,'align_left')]/a")
    private List<WebElement> productsNames;

    @FindBy(xpath = "//div[contains(@Class,'input-group') and contains(@Class,'input-group-sm')]/input")
    private List<WebElement> productsQuantity;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(int index) {
        return getText(productsNames.get(index));
    }

    public String getProductQuantity(int index) {
        return getValue(productsQuantity.get(index));
    }
}
