package homework21.tests;

import homework21.CartPage;

import homework21.Checkout_Step_TwoPage;
import homework21.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static homework21.utils.HelperFunc.getItemNameCheckOut;
import static homework21.utils.HelperFunc.getItemNameInCart;
import static homework21.utils.HelperFunc.getItemPriceCheckOut;
import static homework21.utils.HelperFunc.getItemPriceInCart;
import static homework21.utils.HelperFunc.getOrderMessage;

public class SaucedemoComTest extends BaseTest {

    @Test
    public void BuyAndCheckItemInCart() {

        CartPage cartPage = openLoginPage()
                .login("standard_user", "secret_sauce")
                .buyItemMaxPrice()
                .openCartPage();

        Assert.assertEquals(getItemNameInCart(), "Sauce Labs Fleece Jacket");
        Assert.assertEquals(getItemPriceInCart(), "$49.99");

        Checkout_Step_TwoPage checkoutStepTwoPage = cartPage
                .pressButtonCheckout()
                .setYourInformationAndContinue("Ostap", "Bender", "12345");

        Assert.assertEquals(getItemNameCheckOut(), "Sauce Labs Fleece Jacket");
        Assert.assertEquals(getItemPriceCheckOut(), "$49.99");

        checkoutStepTwoPage.finishButton();
        Assert.assertEquals(getOrderMessage(), "Thank you for your order!");
    }
}
