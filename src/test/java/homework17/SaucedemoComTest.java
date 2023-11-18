package homework17;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertTrue;

public class SaucedemoComTest extends Base {


    private final String USERNAME = "standard_user";
    private final String PASSWORD = "secret_sauce";

    @Test

    public void testLoginAndLogoutAndLinkedInLink() {

        driver.get("https://www.saucedemo.com/");

        //  Login using username and password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(USERNAME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(PASSWORD);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();

        // Click LinkedIn link
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".social_linkedin>a"))).click();

        // Handling the new tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));


        assertTrue(driver.getTitle().contains("LinkedIn"));

        // Close LinkedIn tab and switch back to saucedemo.com
        driver.close();
        driver.switchTo().window(tabs.get(0));

        // Logout
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))).click();

    }
}
