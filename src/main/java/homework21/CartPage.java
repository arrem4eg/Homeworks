package homework21;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private static final SelenideElement checkoutButton = $("#checkout");

    public Checkout_Step_OnePage pressButtonCheckout() {
        checkoutButton.click();
        return new Checkout_Step_OnePage();
    }
}