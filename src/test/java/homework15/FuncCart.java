package homework15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FuncCart extends Base {

    // Method to get the product title based on ID
    String getProductTitle(int id) {
        return driver.findElement(By.xpath("//*[@id='" + id + "']/p")).getText();
    }

    // Method to get the product title in the cart based on the provided title
    String getProductTitleInCart(String productTitleInCart) {
        return driver.findElement(By.xpath("//*[@class='title' and text()='" + productTitleInCart + "']")).getText();
    }

    // Method to get the product price based on ID
    String getProductPrice(int id) {
        return driver.findElement(By.xpath("(//*[@id='" + id + "']/div[3]//b)[1]")).getText();
    }

    // Method to get the product price in the cart based on the provided item
    String getProductPriceInCart(String item) {
        // Cut "$ and .00" from the price in the cart
        return driver.findElement(By.xpath("//*[@class='title' and contains(text(), '" + item + "')]/parent::div/following-sibling::div/p"))
                .getText()
                .substring(2)
                .replaceAll(".00", "");
    }

    // Method to buy an item based on ID
    void buyItem(int id) {
        WebElement element = driver.findElement(By.xpath("//*[@id='" + id + "']/div[4]"));
        element.click();
    }

    // Method to close the cart
    void closeCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement closeCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='float-cart__close-btn']")));
        closeCart.click();
    }

    // Method to get the quantity of items in the cart
    String getQuantityInCart() {
        return driver.findElement(By.xpath("//*[@class='bag__quantity']")).getText();
    }

    // Method to get the subtotal in the cart
    int getSubtotalInCart() {
        // Get subtotal and remove "$ and .00"
        String subtotal = driver.findElement(By.xpath("//*[@class='sub-price__val']")).getText().substring(2).replaceAll(".00", "");
        return Integer.parseInt(subtotal);
    }

    // Method to get the total sum of items in the cart
    int getSumItemInCart() {
        // Loop through the items in the cart and calculate the sum
        int sum = 0;
        for (int i = 1; i < Integer.parseInt(getQuantityInCart()) + 1; i++)
            sum += Integer.parseInt(driver.findElement(By.xpath("(//*[@class='shelf-item__price']/p)[" + i + "]")).getText().substring(2).replaceAll(".00", ""));
        return sum;
    }

    void removeItemFromCart() {
        driver.findElement(By.xpath("//*[@class='shelf-item__del']")).click();
    }

}
