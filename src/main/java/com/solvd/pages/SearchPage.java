package com.solvd.pages;


import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractPage {
    @FindBy(className = "prdocutname")
    private List<WebElement> productNames;

    public SearchPage(WebDriver driver) {
        super(driver);
    }


    public boolean areAllProductNamesMatching(String name) {
        if(StringUtils.isEmpty(name)) {
            logger.info("Attempted check with empty name of product");
            return false;
        }
        List<WebElement> displayedProductNames = productNames.stream().filter(this::isDisplayed).toList();
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
