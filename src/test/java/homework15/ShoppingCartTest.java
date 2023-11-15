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

        // Check if the titles of the items match
        assertEquals(getProductInfoByPath(firstItem, productTitle), "iPhone 12");
        assertEquals(getProductInfoByPath(firstItem, productTitleInCart), "iPhone 12");
        assertEquals(getProductInfoByPath(secondItem, productTitle), "iPhone 12 Mini");
        assertEquals(getProductInfoByPath(secondItem, productTitleInCart), "iPhone 12 Mini");

        // Check if the prices of the items match
        assertEquals(getProductInfoByPath(firstItem, productPrice).substring(1).replaceAll("\n.*", ""), "799.00");
        assertEquals(getProductInfoByPath(firstItem, productPriceInCart).substring(2).replaceAll("\n.*", ""), "799.00");
        assertEquals(getProductInfoByPath(secondItem, productPrice).substring(1).replaceAll("\n.*", ""), "699.00");
        assertEquals(getProductInfoByPath(secondItem, productPriceInCart).substring(2).replaceAll("\n.*", ""), "699.00");

        // Check the total quantity in the cart
        assertEquals(getProductInfoByClass(quantityInCart), "2");

        // Check the total sum in the cart
        String subtotalInCart = getProductInfoByClass(subtotal).replaceAll("\\$ ", "");
        String sumAllItemsInCart = getSumItemInCart();
        assertEquals(subtotalInCart, sumAllItemsInCart);
        assertEquals(subtotalInCart, "1498.00");
        assertEquals(sumAllItemsInCart, "1498.00");

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


        // Check that the quantity in the cart is now 0
        assertEquals(getProductInfoByClass(quantityInCart), "0");

        // Ensure the subtotal is zero after removing all items
        assertEquals(getProductInfoByClass(subtotal).replaceAll("\\$ ", ""), "0.00");


        // Check the visibility of the CONTINUE SHOPPING button
        assertFalse(driver.findElements(By.xpath(continueShoppingButton)).isEmpty());
    }

}
