package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends AbstractPage {
    @FindBy(className = "prdocutname")
    List<WebElement> productNames;

    public SearchPage(WebDriver driver) {
        super(driver);
    }


    public boolean areAllProductNamesMatching(String name) {
        List<WebElement> displayedProductNames = productNames.stream().filter(element -> isDisplayed(element)).collect(Collectors.toList());
        for (WebElement productName : displayedProductNames) {
            String productText = getText(productName);
            logger.info("Checking name of product: {}", productText);
            if(!productText.toLowerCase().contains(name.toLowerCase())) {
                return false;
            }
        }
        return true;
    }


}
