package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(id = "loginFrm_loginname")
    private WebElement loginNameForm;

    @FindBy(id = "loginFrm_password")
    private WebElement loginPasswordForm;

    @FindBy(xpath = "//button[@title='Login']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private void enterLogin(String login) {
        sendKeys(loginNameForm, login);
    }

    private void enterPassword(String password) {
        sendKeys(loginPasswordForm, password);
    }

    private AccountPage clickLogin() {
        clickElement(loginButton);
        return new AccountPage(driver);
    }

    public AccountPage performLogin(String login, String password) {
        enterLogin(login);
        enterPassword(password);
        return clickLogin();
    }
}
