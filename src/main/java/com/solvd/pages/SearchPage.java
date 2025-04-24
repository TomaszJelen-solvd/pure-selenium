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

//    public SearchPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }

    public boolean areAllProductNamesMatching(String name) {
        List<WebElement> displyedProductNames = productNames.stream().filter(element -> checkIfDisplayed(element)).collect(Collectors.toList());
        for (WebElement productName : displyedProductNames) {
            if(!getTextFrom(productName).toLowerCase().contains(name.toLowerCase())) {
                return false;
            }
        }
        return true;
    }


}
