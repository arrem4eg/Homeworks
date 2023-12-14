package homework21;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class Checkout_Step_TwoPage {

    private static final SelenideElement finishButtonElement = $("#finish");

    public Checkout_CompletePage finishButton() {
        finishButtonElement.click();
        return new Checkout_CompletePage();
    }
}
