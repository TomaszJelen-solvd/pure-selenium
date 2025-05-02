package com.solvd;

import com.solvd.pages.CartPage;
import com.solvd.pages.HomePage;
import static com.solvd.ProductService.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;



public class CartTest extends AbstractTest {
    //    CID1
    @Test
    public void testDisplayChosenProductInCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToHomePage();

        homePage.addProductToCart(SKINSHEEN_BRONZER_STICK.getIndex());
        CartPage cartPage = homePage.clickCart();
        Assert.assertEquals(cartPage.getProductName(0), SKINSHEEN_BRONZER_STICK.getName(), "Failed to display correct product");
        Assert.assertEquals(cartPage.getProductQuantity(0), "1", "Failed to display correct product quantity");
    }

//    CID2
    @Test
    public void testDisplayDifferentChosenProductsInCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToHomePage();

        homePage.addProductToCart(SKINSHEEN_BRONZER_STICK.getIndex());
        homePage.addProductToCart(TREATMENT_SPF_15.getIndex());
        CartPage cartPage = homePage.clickCart();
        assertProductsInCart(cartPage, Map.of(
                SKINSHEEN_BRONZER_STICK.getName(), "1",
                TREATMENT_SPF_15.getName(), "1"
        ));
    }

//    CID3
    @Test
    public void testDisplayDiffrentMultipleChosenProductsInCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToHomePage();

        homePage.addSeveralProductsToCart(SKINSHEEN_BRONZER_STICK.getIndex(), 2);
        homePage.addProductToCart(TREATMENT_SPF_15.getIndex());
        CartPage cartPage = homePage.clickCart();
        assertProductsInCart(cartPage, Map.of(
                SKINSHEEN_BRONZER_STICK.getName(), "2",
                TREATMENT_SPF_15.getName(), "1"
                ));
    }

    private static void assertProductsInCart(CartPage cartPage, Map<String, String> expectedProducts) {
        int i = 0;
        for(Map.Entry<String, String> entry : expectedProducts.entrySet()) {
            Assert.assertEquals(cartPage.getProductName(i), entry.getKey(), "Failed to display correct product");
            Assert.assertEquals(cartPage.getProductQuantity(i), entry.getValue(), "Failed to display correct product quantity");
            i++;
        }
    }
}
