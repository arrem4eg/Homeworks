package homework21;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Checkout_Step_OnePage {
    private static final SelenideElement firstNameElement = $("#first-name");
    private static final SelenideElement lastNameElement = $("#last-name");
    private static final SelenideElement postCodeElement = $("#postal-code");
    private static final SelenideElement continueBtnElement = $("#continue");

    public Checkout_Step_TwoPage setYourInformationAndContinue(String firstName, String lastName, String postalCode) {
        firstNameElement.setValue(firstName);
        lastNameElement.setValue(lastName);
        postCodeElement.setValue(postalCode);
        continueBtnElement.click();
        return new Checkout_Step_TwoPage();
    }
}