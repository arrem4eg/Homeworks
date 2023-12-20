package homework21.utils;

import com.codeborne.selenide.Configuration;
import homework21.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    @BeforeTest
    public static void beforeTest() {
        System.out.println("------------ Testing started ----------------");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("------------ Testing finished ----------------");
    }

    @BeforeMethod
    public void beforeMethod() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    public LoginPage openLoginPage() {
        open("https://www.saucedemo.com/");
        return new LoginPage();
    }
}