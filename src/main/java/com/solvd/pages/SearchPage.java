package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    WebDriver driver;

    @FindBy(id = "prdocutname")
    List<WebElement> productNames;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean areAllProductNamesMatch(String name) {
        for (WebElement productName : productNames) {
            if(!productName.getText().toLowerCase().contains(name.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

}
