package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage{
    @FindBy(xpath = "//div[@class='container-fluid cart-info product-list']/table/tbody/tr[position() > 1]/td[2]/a")
    List<WebElement> productsNames;

    @FindBy(xpath = "//div[@class='container-fluid cart-info product-list']/table/tbody/tr[position() > 1]/td[5]/div/input")
    List<WebElement> productsQuantity;

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
