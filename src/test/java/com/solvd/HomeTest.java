package com.solvd;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.pages.HomePage;
import com.solvd.pages.SearchPage;

//Implementation of Web Automation Java Task 1
public class HomeTest extends AbstractTest {
    @Test
    public void testDisplayMainMenuOnHover() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToHomePage();

        homePage.hoverOverHomeButton();
        Assert.assertTrue(homePage.isHomeMenuVisible(), "Main menu was not visible after hovering over Home button");
    }

//    CID1
    @Test
    public void testDisplaySearchedProducts() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToHomePage();

        String productName = "bronzer";
        homePage.enterSearchQuery(productName);
        SearchPage searchPage = homePage.clickSearch();
        Assert.assertTrue(searchPage.areAllProductNamesMatching(productName), "Failed to find only searched product");
    }


}
