package com.solvd;

import com.solvd.pages.CartPage;
import com.solvd.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends AbstractTest{
//    CID1
    @Test
    public void testDisplayChosenProductInCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToHomePage();

        homePage.addProductToCart(0);
        CartPage cartPage = homePage.clickCart();
        Assert.assertEquals(cartPage.getProductName(0), "Skinsheen Bronzer Stick", "Failed to display correct product");
        Assert.assertEquals(cartPage.getProductQuantity(0), "1", "Failed to display correct product quantity");
    }

//    CID2
    @Test
    public void testDisplayDiffrentChosenProductsInCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToHomePage();

        homePage.addProductToCart(0);
        homePage.addProductToCart(3);
        CartPage cartPage = homePage.clickCart();
        Assert.assertEquals(cartPage.getProductName(0), "Skinsheen Bronzer Stick", "Failed to display correct product");
        Assert.assertEquals(cartPage.getProductName(1), "Absolute Anti-Age Spot Replenishing Unifying TreatmentSPF 15", "Failed to display correct product");
        Assert.assertEquals(cartPage.getProductQuantity(0), "1", "Failed to display correct product quantity");
        Assert.assertEquals(cartPage.getProductQuantity(1), "1", "Failed to display correct product quantity");
    }


//    CID3
    @Test
    public void testDisplayDiffrentMultipleChosenProductsInCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToHomePage();

        homePage.addProductToCart(0);
        homePage.addProductToCart(0);
        homePage.addProductToCart(3);
        CartPage cartPage = homePage.clickCart();
        Assert.assertEquals(cartPage.getProductName(0), "Skinsheen Bronzer Stick", "Failed to display correct product");
        Assert.assertEquals(cartPage.getProductName(1), "Absolute Anti-Age Spot Replenishing Unifying TreatmentSPF 15", "Failed to display correct product");
        Assert.assertEquals(cartPage.getProductQuantity(0), "2", "Failed to display correct product quantity");
        Assert.assertEquals(cartPage.getProductQuantity(1), "1", "Failed to display correct product quantity");
    }

}
