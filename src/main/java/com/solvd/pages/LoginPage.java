package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{
    @FindBy(id = "loginFrm_loginname")
    WebElement loginNameForm;

    @FindBy(id = "loginFrm_password")
    WebElement loginPasswordForm;

    @FindBy(xpath = "//button[@title='Login']")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterLogin(String login) {
        sendKeys(loginNameForm, login);
    }

    public void enterPassword(String password) {
        sendKeys(loginPasswordForm, password);
    }

    public AccountPage clickAccount() {
        clickElement(loginButton);
        return new AccountPage(driver);
    }
}
