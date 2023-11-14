package homework15;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class ShoppingCartTest extends FuncCart {

    int firstItem = 1;
    int secondItem = 2;

    @Test()
    public void testAddToCartAndVerify() {

        // Add the first item to the cart
        findElementAndClick(firstItem, buyItemButton);

        // Close the cart
        findElementAndClickByClass(closeCart);

        // Add the second item to the cart
        findElementAndClick(secondItem, buyItemButton);

        // Compare titles in the cart with the added items
        assertEquals(getProductInfoByPath(firstItem, productTitle), getProductInfoByPath(firstItem, productTitleInCart));
        assertEquals(getProductInfoByPath(secondItem, productTitle), getProductInfoByPath(secondItem, productTitleInCart));

        // Compare prices in the cart with the added items
        assertEquals(getProductInfoByPath(firstItem, productPrice).substring(1).replaceAll("\n.*", ""),
                getProductInfoByPath(firstItem, productPriceInCart).substring(2).replaceAll("\n.*", ""));

        assertEquals(getProductInfoByPath(secondItem, productPrice).substring(1).replaceAll("\n.*", ""),
                getProductInfoByPath(secondItem, productPriceInCart).substring(2).replaceAll("\n.*", ""));

        // Check the total quantity in the cart
        assertEquals(getProductInfoByClass(quantityInCart), "2");

        // Check the total sum in the cart
        BigDecimal subtotalInCart = new BigDecimal(getProductInfoByClass(subtotal).replaceAll("\\$ ", ""));
        BigDecimal sum = getSumItemInCart();
        assertEquals(subtotalInCart, sum);

        // Check the visibility of the CHECKOUT button
        assertTrue(driver.findElement(By.className(checkout)).isDisplayed());
    }

    @Test()
    public void testRemoveItemFromCartAndVerify() {

        // Add the first item to the cart
        findElementAndClick(firstItem, buyItemButton);

        // Check that the cart is not empty after adding the item
        assertTrue(driver.findElements(By.className(emptyCart)).isEmpty());

        // Remove the item from the cart
        findElementAndClickByClass(removeItemFromCart);

        // Verify that the cart is empty after removing the item
        assertFalse(driver.findElements(By.className(emptyCart)).isEmpty());


        // Check that the subtotal in the cart is now 0
        assertEquals(getProductInfoByClass(quantityInCart), "0");

        // Check the visibility of the CONTINUE SHOPPING button
        assertFalse(driver.findElements(By.xpath(continueShoppingButton)).isEmpty());
    }

}
