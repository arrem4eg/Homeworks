package homework21.tests;

import homework21.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static homework21.CartPage.getItemNameInCart;
import static homework21.CartPage.getItemPriceInCart;

public class SaucedemoComTest extends BaseTest {

    @Test
    public void BuyAndCheckItemInCart() {

        openLoginPage()
                .login("standard_user", "secret_sauce")
                .buyItemMaxPrice()
                .openCartPage();

        Assert.assertEquals(getItemNameInCart(),"Sauce Labs Fleece Jacket");
        Assert.assertEquals(getItemPriceInCart(), "$49.99");
    }

    @Test
    public void fullBuyTest() {

                openLoginPage()
                .login("standard_user", "secret_sauce")
                .buyItemMaxPrice()
                .openCartPage()
                .pressButtonCheckout()
                .setYourInformationAndContinue("Ostap", "Bender", "12345")
                .finishButton()
                .backInventoryPage();
    }
}
