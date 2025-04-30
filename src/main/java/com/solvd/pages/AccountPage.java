package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage{
    @FindBy(className = "subtext")
    WebElement userName;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUserName() {
        return getText(userName);
    }
}
