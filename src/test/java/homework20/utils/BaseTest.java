package homework20.utils;

import homework20.DownloadPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public abstract class BaseTest {

    protected static WebDriver driver;
    public static PropTest props;

    @BeforeTest
    public static void beforeTest() {
        System.out.println("------------ Testing started ----------------");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("------------ Testing finished ----------------");
    }

    @BeforeClass
    public void beforeClass() {
        props = new PropTest();
    }

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", new File(props.getData("downloadFolder")).getAbsolutePath());
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @AfterMethod
    public static void afterMethod() {
        if (driver != null)
            driver.quit();
        new File(props.getData("downloadFolder") + props.getData("fileName")).delete();
        new File(props.getData("downloadFolder")).delete();
    }

    public DownloadPage openDownloadPage() {
        driver.get(props.getData("url"));
        return new DownloadPage(driver);
    }
}
