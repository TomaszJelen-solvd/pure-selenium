package com.solvd;

import com.solvd.pages.AccountPage;
import com.solvd.pages.HomePage;
import com.solvd.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest{
//    CID4
    @Test
    public void testCorrectLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToHomePage();

        LoginPage loginPage = homePage.clickLogin();
        loginPage.enterLogin("autologin");
        loginPage.enterPassword("autopassword");
        AccountPage accountPage = loginPage.clickAccount();
        Assert.assertEquals(accountPage.getUserName(), "a", "Failed to display correct username");
    }
}
