package com.solvd;

import com.solvd.pages.AccountPage;
import com.solvd.pages.HomePage;
import com.solvd.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest{

    public static final String LOGIN = "autologin";
    public static final String PASSWORD = "autopassword";
    public static final String USERNAME = "a";

    //    CID4
    @Test
    public void testCorrectLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToHomePage();

        LoginPage loginPage = homePage.clickLogin();
        AccountPage accountPage = loginPage.performLogin(LOGIN, PASSWORD);
        Assert.assertEquals(accountPage.getUserName(), USERNAME, "Failed to display correct username");
    }
}
