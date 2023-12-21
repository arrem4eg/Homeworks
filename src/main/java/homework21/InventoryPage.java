package homework21;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class InventoryPage {

    private static final SelenideElement cartLink = $(".shopping_cart_link");
    private static final SelenideElement addToCartButton = $x("//button[text()='Add to cart']");
    private static final SelenideElement sortSelectElement = $x("//*[text()='Price (high to low)']");

    public InventoryPage buyItemMaxPrice() {
        sortSelectElement.click();
        addToCartButton.click();
        return this;
    }

    public CartPage openCartPage() {
        cartLink.click();
        return new CartPage();
    }
}