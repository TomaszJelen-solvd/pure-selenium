package com.solvd;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.pages.HomePage;
import com.solvd.pages.SearchPage;

//Implementation of Web Automation Java Task 1
public class BasicHomePageTests extends AbstractTest {
    @Test
    public void checkIfHoveringDisplaysMainMenuTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToHomePage();

        homePage.hoverOverHomeButton();
        Assert.assertTrue(homePage.isHomeMenuVisible(), "Failed to display main menu");
    }

    @Test
    public void checkIfSearchedProductsHaveLookedForNamesTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToHomePage();

        String productName = "bronzer";
        homePage.enterSearchQuery(productName);
        SearchPage searchPage = homePage.clickSearch();
        Assert.assertTrue(searchPage.areAllProductNamesMatching(productName), "Failed to find only searched product");
    }


}
