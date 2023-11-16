package homework16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class SeleniumDevTest extends Base {

    @Test
    public void addBoxTest() {

        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.id("adder")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box0")));

        assertTrue(box.isDisplayed());
        assertEquals(box.getCssValue("width"), "150px");
        assertEquals(box.getCssValue("height"), "150px");
    }


    @Test
    public void revealNewInputTest() {

        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.id("reveal")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement revealed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed")));

        assertTrue(revealed.isDisplayed());
        revealed.sendKeys("java");
        assertEquals(revealed.getAttribute("value"), "java");

    }
}

