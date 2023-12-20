package homework23.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private static final SelenideElement userNameElement = $("input[formcontrolname='username']");
    private static final SelenideElement passwordElement = $("input[formcontrolname='password']");
    private static final SelenideElement loginBtn = $("mat-card-actions>button");
    private static final SelenideElement loginBtnElement = $x(".//button[span[text()='Login']]");

    public MainPage loginWithUserNameAndPassword(String userName, String password) {
        userNameElement.setValue(userName);
        passwordElement.setValue(password);
        loginBtn.click();
        loginBtnElement.should(disappear);
        return new MainPage();
    }
}
