package homework23.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    static final SelenideElement searchBox = $(".mat-autocomplete-trigger");
    static final SelenideElement confirmSearch = $("span.mat-option-text");
    static final SelenideElement addToCartBtn = $("app-addtocart>button");
    static final SelenideElement loginBtn = $x(".//button[span[text()='Login']]");
    static final SelenideElement cartBtn =
            $("button[class='mat-focus-indicator mat-icon-button mat-button-base']");
    public static final SelenideElement badge0 = $("#mat-badge-content-0");

    public MainPage searchBook(String book) {
        searchBox.setValue(book);
        confirmSearch.click();
        return this;
    }

    public MainPage addToCart() {
        addToCartBtn.click();
        return this;
    }

    public LoginPage clickLoginBtn() {
        loginBtn.click();
        return new LoginPage();
    }

    public CartPage goToCartPage(String quantityInCart) {
        badge0.shouldHave(text(quantityInCart));
        cartBtn.click();
        return new CartPage();
    }
}
