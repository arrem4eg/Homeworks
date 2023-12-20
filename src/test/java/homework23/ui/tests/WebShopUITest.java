package homework23.ui.tests;

import homework23.api.tests.WebShopApiTest;
import homework23.ui.CartPage;
import homework23.ui.CheckOutPage;
import homework23.ui.utils.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import static homework23.ui.utils.HelpFunc.*;
import static homework23.ui.utils.HelpFunc.getOrderOn;

public class WebShopUITest extends BaseTest {

    @Test()
    public void buyAndCheckItemInCartAndCheckOut() {

        WebShopApiTest.createUser();
        String userName = WebShopApiTest.createdUser.getUsername();
        String password = WebShopApiTest.createdUser.getPassword();

        CartPage cartPage = openMainPage()
                .searchBook("HP3")
                .addToCart()
                .clickLoginBtn()
                .loginWithUserNameAndPassword(userName, password)
                .goToCartPage();

        Assert.assertEquals(getTitleInCart(), "HP3");
        Assert.assertEquals(getPriceItemInCart(), "₹213.00");
        Assert.assertEquals(getQuantityItemsInCart(), "1");

        CheckOutPage checkOutPage = cartPage.goToCheckOutPage();

        Assert.assertEquals(getTitleCheckOut(), "HP3");
        Assert.assertEquals(getPriceCheckOut(), "₹213.00");
        Assert.assertEquals(getQuantityItemsCheckOut(), "1");

        checkOutPage.goToMyOrderPage(
                getName(),
                getAddress(),
                getAddress(),
                getPinCode(),
                getState()
        );

        Assert.assertNotEquals(getOrderId(), "");
        Assert.assertEquals(getOrderOn(), getDate());
        Assert.assertEquals(getOrderTotal(), "₹213.00");
    }
}
