package homework19.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class BasePage {


    public final WebDriver driver;
    public final WebDriverWait wait;
    public Properties properties;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        this.properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/contactUs.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickButton(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void setText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public String getData(String element) {
        return properties == null ? null : properties.getProperty(element);
    }
}
