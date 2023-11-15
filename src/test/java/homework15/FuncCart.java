package homework15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.time.Duration;

public class FuncCart extends Base {

    final String idToTitle = "//*[@id='%d']//*[@class='shelf-item__title']";
    final String productTitle = "//*[@class='shelf-container']//*[text()='%s']";
    final String productTitleInCart = "//*[@class='title' and text()='%s']";
    final String productPrice = "//*[@class='shelf-container']//*[text()='%s']/following-sibling::div";
    final String productPriceInCart = "//*[@class='title' and normalize-space(text())='%s']//parent::div/following-sibling::div";
    final String buyItemButton = "//div[@id='%d']//div[@class='shelf-item__buy-btn']";
    final String closeCart = "float-cart__close-btn";
    final String quantityInCart = "bag__quantity";
    final String subtotal = "sub-price__val";
    final String checkout = "buy-btn";
    final String removeItemFromCart = "shelf-item__del";
    final String emptyCart = "shelf-empty";
    final String continueShoppingButton = "//*[text()='Continue Shopping']";


    String getProductInfoByPath(int itemNumber, String path) {
        String title = driver.findElement(By.xpath(String.format(idToTitle, itemNumber))).getText();    // get title from id
        return driver.findElement(By.xpath(String.format(path, title))).getText();
    }

    String getProductInfoByClass(String path) {
        return driver.findElement(By.className(path)).getText();
    }

    void findElementAndClick(int itemNumber, String path) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(path, itemNumber))));
        element.click();
    }

    void findElementAndClickByClass(String path) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className(path)));
        element.click();
    }

    // Method to get the total sum of items in the cart
    String getSumItemInCart() {
        // Loop through the items in the cart and calculate the sum
        BigDecimal sum = BigDecimal.valueOf(0);
        for (int i = 1; i <= Integer.parseInt(getProductInfoByClass(quantityInCart)); i++) {
            BigDecimal temp = new BigDecimal(getProductInfoByPath(i, productPriceInCart).substring(2).replaceAll("\n.*", ""));
            sum = sum.add(temp);
        }
        return sum.toString();
    }
}
