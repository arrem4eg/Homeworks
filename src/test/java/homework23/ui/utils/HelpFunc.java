package homework23.ui.utils;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HelpFunc {
    private static final SelenideElement titleInCartEl = $("td>a");
    private static final SelenideElement titleCheckOutEl = $("td>a");
    private static final SelenideElement priceInCartEl = $x("//a/../following-sibling::td");
    private static final SelenideElement priceCheckOutEl = $x("//a/../following-sibling::td/following-sibling::td");
    private static final SelenideElement quantityInCartEl = $("#mat-badge-content-0");
    private static final SelenideElement quantityCheckOutEl = $x("//a/../following-sibling::td");
    private static final SelenideElement orderIdEl = $x("//tr/td");
    private static final SelenideElement orderOnEl = $x("//tbody/tr/td/following-sibling::td");
    private static final SelenideElement orderTotalEl = $x("//tbody/tr/td/following-sibling::td/following-sibling::td");
    private static final Faker faker = new Faker();

    public static String getTitleInCart() {
        return titleInCartEl.getText();
    }

    public static String getPriceItemInCart() {
        return priceInCartEl.getText();
    }

    public static String getQuantityItemsInCart() {
        return quantityInCartEl.getText();
    }

    public static String getTitleCheckOut() {
        return titleCheckOutEl.getText();
    }

    public static String getQuantityItemsCheckOut() {
        return quantityCheckOutEl.getText();
    }

    public static String getPriceCheckOut() {
        return priceCheckOutEl.getText();
    }

    public static String getName() {
        return faker.name().fullName();
    }

    public static String getAddress() {
        return faker.address().streetAddress();
    }

    public static String getPinCode() {
        return String.valueOf(faker.number().numberBetween(111111, 999999));
    }

    public static String getState() {
        return faker.address().state();
    }

    public static String getOrderId() {
        return orderIdEl.getText();
    }

    public static String getOrderOn() {
        return orderOnEl.getText().trim();
    }

    public static String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy");
        return simpleDateFormat.format(new Date());
    }

    public static String getOrderTotal() {
        return orderTotalEl.getText();
    }


}
