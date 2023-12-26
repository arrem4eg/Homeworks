package homework23.ui.tests;

import homework23.api.dto.UserDataDTO;
import homework23.listeners.UITestListener;
import homework23.ui.CartPage;
import homework23.ui.CheckOutPage;
import homework23.ui.utils.BaseTest;

import homework23.ui.utils.CreateUserApi;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static homework23.ui.utils.HelpFunc.*;
import static homework23.ui.utils.HelpFunc.getOrderOn;

@Listeners(UITestListener.class)
public class WebShopUITest extends BaseTest {
    private static final String QUANTITY_IN_CART = "1";

    @Test()
    public void buyAndCheckItemInCartAndCheckOut() {

        UserDataDTO user = CreateUserApi.createUser();
        String userName = user.getUsername();
        String password = user.getPassword();

        CartPage cartPage = openMainPage()
                .searchBook("HP3")
                .addToCart()
                .clickLoginBtn()
                .loginWithUserNameAndPassword(userName, password)
                .goToCartPage(QUANTITY_IN_CART);

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
