package homework18.tests;

import homework18.pages.*;
import homework18.utils.BaseTest;
import org.testng.annotations.Test;

public class SaucedemoComTest extends BaseTest {

    @Test
    public void BuyItemMaxPrice() {

        InventoryPage buyAndBackInventoryPage = openMainPage()
                .login("standard_user", "secret_sauce")
                .buyItemMaxPrice()
                .openCartPage()
                .pressButtonCheckout()
                .setYourInformationAndContinue("Ostap", "Bender", "12345")
                .finish()
                .backInventoryPage();
    }
}