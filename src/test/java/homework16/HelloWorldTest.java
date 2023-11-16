package homework16;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class HelloWorldTest extends Base {

    @Test
    public void hiddenElementTest() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("#start>button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement helloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish>h4")));

        assertEquals(helloWorld.getText(), "Hello World!");
    }

    @Test
    public void renderableElementTest() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        driver.findElement(By.cssSelector("#start>button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement helloWorld = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#finish>h4")));

        assertEquals(helloWorld.getText(), "Hello World!");
    }
}