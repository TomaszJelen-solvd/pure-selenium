package com.solvd;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.pages.HomePage;
import com.solvd.pages.SearchPage;

//Implementation of Web Automation Java Task 1
public class SimpleWebAutomationTest extends AbstractTest {
    @Test
    public void displayMainMenuTest() {
        HomePage startingHomePage = new HomePage(driver());
        startingHomePage.navigateToHomePage();

        startingHomePage.hoverOverHomeButton();
        Assert.assertTrue(startingHomePage.isHomeMenuVisible(), "Failed to display main menu");
    }

    @Test
    public void searchForProductsTest() {
        HomePage startingHomePage = new HomePage(driver());
        startingHomePage.navigateToHomePage();

        String productName = "bronzer";
        startingHomePage.enterSearchQuery(productName);
        SearchPage searchPage = startingHomePage.clickSearch();
        Assert.assertTrue(searchPage.areAllProductNamesMatching(productName), "Failed to find only searched product");
    }


}
