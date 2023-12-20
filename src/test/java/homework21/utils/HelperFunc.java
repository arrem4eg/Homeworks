package homework21.utils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HelperFunc {

    private static final SelenideElement itemNameInCart = $(".inventory_item_name");
    private static final SelenideElement itemPriceInCart = $(".inventory_item_price");
    private static final SelenideElement itemNameCheckOutElement = $("#item_5_title_link");
    private static final SelenideElement itemPriceCheckOutElement = $(".inventory_item_price");
    private static final SelenideElement orderMessage = $(".complete-header");

    public static String getItemNameInCart() {
        return itemNameInCart.getText();
    }

    public static String getItemPriceInCart() {
        return itemPriceInCart.getText();
    }

    public static String getItemNameCheckOut() {
        return itemNameCheckOutElement.getText();
    }

    public static String getItemPriceCheckOut() {
        return itemPriceCheckOutElement.getText();
    }

    public static String getOrderMessage() {
        return orderMessage.getText();
    }
}
