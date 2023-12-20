package homework21;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage  {

    private static final SelenideElement userNameElement = $("#user-name");
    private static final SelenideElement passwordElement = $("#password");
    private static final SelenideElement submitBtnElement = $("#login-button");

    public InventoryPage login(String userName, String password) {
        userNameElement.setValue(userName);
        passwordElement.setValue(password);
        submitBtnElement.click();
        return new InventoryPage();
    }
}