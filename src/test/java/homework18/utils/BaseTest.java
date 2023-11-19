package homework18.utils;

import homework18.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    protected static WebDriver driver;

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
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @AfterMethod
    public static void afterMethod() {
        if (driver != null)
            driver.quit();
    }

    public MainPage openMainPage() {
        driver.get("https://www.saucedemo.com/");
        return new MainPage(driver);
    }
}
