package homework23.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckOutPage {
    private static final SelenideElement nameEl = $x("//input[@formcontrolname='name']");
    private static final SelenideElement addressLine1El = $x("//input[@formcontrolname='addressLine1']");
    private static final SelenideElement addressLine2El = $x("//input[@formcontrolname='addressLine2']");
    private static final SelenideElement pinCodeEl = $x("//input[@formcontrolname='pincode']");
    private static final SelenideElement stateEl = $x("//input[@formcontrolname='state']");
    private static final SelenideElement placeOrderEl = $x("//button[span[text()='Place Order']]");

    public void goToMyOrderPage(String name, String addressLine1,
                                String addressLine2, String pinCode, String state) {
        nameEl.setValue(name);
        addressLine1El.setValue(addressLine1);
        addressLine2El.setValue(addressLine2);
        pinCodeEl.setValue(pinCode);
        stateEl.setValue(state);
        placeOrderEl.click();
    }
}
