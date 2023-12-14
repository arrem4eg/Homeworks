package homework21;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Checkout_CompletePage {
    private static final SelenideElement backHomeButton = $("#back-to-products");

    public void backInventoryPage() {
        backHomeButton.click();
    }
}
