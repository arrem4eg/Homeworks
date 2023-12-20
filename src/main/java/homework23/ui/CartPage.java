package homework23.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CartPage {
    private static final SelenideElement checkOutBtnEl = $x("//button[span[text()='CheckOut']]");

    public CheckOutPage goToCheckOutPage() {
        checkOutBtnEl.click();
        return new CheckOutPage();
    }
}
