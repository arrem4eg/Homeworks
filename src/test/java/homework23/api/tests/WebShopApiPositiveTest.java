package homework23.api.tests;

import homework23.api.dto.*;
import homework23.api.services.CheckOutService;
import homework23.api.utils.FakeUserData;
import homework23.api.utils.HttpStatusCode;
import homework23.listeners.ApiTestListener;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Listeners(ApiTestListener.class)
public class WebShopApiPositiveTest extends WebShopApiHelper {

    @Test
    public static void createUser() {
        createdUser = FakeUserData.createUserData();
        Response response = userService.registerNewUser(createdUser);

        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());
    }

    @Test(dependsOnMethods = "createUser")
    public void loginCreatedUser() {

        Response response = loginService.loginCreatedUser(createdUser);
        loginUser = response.then().extract().as(LoginResponseDTO.class);

        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());
        assertNotNull(loginUser.getToken());
    }

    @Test(dependsOnMethods = {"loginCreatedUser", "createUser"})
    public void addToCart() {
        Response response = shoppingCartService.addToCart(loginUser.getUserDTO().getUserId(), BOOK_ID);

        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());
        assertNotEquals(response.getBody().asString(), "");
    }

    @Test(dependsOnMethods = {"loginCreatedUser", "createUser", "addToCart"})
    public void checkUserCart() {
        Response response = shoppingCartService.checkUserCart(loginUser.getUserDTO().getUserId());
        cart = response.jsonPath().getList("", ShoppingCartResponseDTO.class);
        orderDetails = response.jsonPath().getList("", OrderDetailsDTO.class);
        BookDataDTO bookInCart = cart.get(0).getBook();

        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());
        assertNotNull(cart);
        assertEquals(bookInCart.getBookId(), BOOK_ID);
        assertEquals(bookInCart.getAuthor(), "JKR");
        assertEquals(bookInCart.getCategory(), "Mystery");
        assertEquals(bookInCart.getTitle(), "HP5");
        assertEquals(bookInCart.getPrice(), 432.00);
    }

    @Test(dependsOnMethods = {"loginCreatedUser", "createUser", "addToCart", "checkUserCart"})
    public void checkOut() {
        CheckOutService checkOutService = new CheckOutService();
        Response response = checkOutService.checkOut(loginUser, FakeUserData.createOrderDTO(orderDetails));

        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());
    }
}
