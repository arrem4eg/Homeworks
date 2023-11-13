package homework15;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ShoppingCartTest extends FuncCart {

    int firstItem = 1;
    int secondItem = 2;

    @Test(priority = 1)
    public void testAddToCartAndVerify() {

        // Add the first item to the cart
        buyItem(firstItem);

        // Close the cart
        closeCart();

        // Add the second item to the cart
        buyItem(secondItem);


        // Compare titles in the cart with the added items
        assertEquals(getProductTitle(firstItem), getProductTitleInCart(getProductTitle(firstItem)));
        assertEquals(getProductTitle(secondItem), getProductTitleInCart(getProductTitle(secondItem)));

        // Compare prices in the cart with the added items
        assertEquals(getProductPrice(firstItem), getProductPriceInCart(getProductTitle(firstItem)));
        assertEquals(getProductPrice(secondItem), getProductPriceInCart(getProductTitle(secondItem)));


        // Check the total quantity in the cart
        assertEquals(getQuantityInCart(), "2");

        // Check the total sum in the cart
        assertEquals(getSubtotalInCart(), getSumItemInCart());

        // Check the visibility of the CHECKOUT button
        assertTrue(driver.findElement(By.xpath("//*[@class='buy-btn']")).isDisplayed());
    }

    @Test(priority = 2)
    public void testRemoveItemFromCartAndVerify() {

        // Add the first item to the cart
        buyItem(firstItem);

        // Check that the cart is not empty after adding the item
        assertTrue(driver.findElements(By.xpath("//*[@class='shelf-empty']")).isEmpty());

        // Remove the item from the cart
        removeItemFromCart();

        // Verify that the cart is empty after removing the item
        assertFalse(driver.findElements(By.xpath("//*[@class='shelf-empty']")).isEmpty());
        assertEquals(driver.findElement(By.xpath("//*[@class='shelf-empty']")).getText(), "Add some products in the bag\n" + ":)");

        // Check that the subtotal in the cart is now 0
        assertEquals(getSubtotalInCart(), 0);

        // Check the visibility of the CONTINUE SHOPPING button
        assertFalse(driver.findElements(By.xpath("//div[@class='buy-btn' and text()='Continue Shopping']")).isEmpty());
    }

}
