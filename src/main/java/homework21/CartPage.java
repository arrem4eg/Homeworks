package homework21;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
private static final SelenideElement checkoutButton = $("#checkout");
private static final SelenideElement itemNameInCart = $(".inventory_item_name");
private static final SelenideElement itemPriceInCart = $(".inventory_item_price");
    public Checkout_Step_OnePage pressButtonCheckout() {
        checkoutButton.click();
        return new Checkout_Step_OnePage();
    }

    public static String getItemNameInCart () {
        return itemNameInCart.getText();
    }

    public static String getItemPriceInCart() {
        return itemPriceInCart.getText();
    }
}
