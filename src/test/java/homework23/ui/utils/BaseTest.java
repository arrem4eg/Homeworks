package homework23.ui.utils;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.logevents.SelenideLogger;
import homework23.ui.MainPage;
import io.qameta.allure.selenide.AllureSelenide;
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
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = "chrome";
        Configuration.savePageSource = false;
        Configuration.browserSize = "1920x1080";
    }

    public MainPage openMainPage() {
        open("https://bookcart.azurewebsites.net/");
        return new MainPage();
    }
}
