package homework23.api.tests;

import homework23.api.dto.*;
import homework23.api.services.CheckOutService;
import homework23.api.services.LoginService;
import homework23.api.services.ShoppingCartService;
import homework23.api.services.UserService;
import homework23.api.utils.FakeUserData;
import homework23.api.utils.HttpStatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class WebShopApiTest {
    private static final UserService userService = new UserService();
    private static final LoginService loginService = new LoginService();
    private static final ShoppingCartService shoppingCartService = new ShoppingCartService();
    public static UserDataDTO createdUser;
    private static LoginResponseDTO loginUser;
    private static List<ShoppingCartResponseDTO> cart;
    private static List<OrderDetailsDTO> orderDetails;
    private static final int BOOK_ID = 5;

    @Test
    public static void createUser() {
        createdUser = FakeUserData.createUserData();
        Response response = userService.registerNewUser(createdUser);

        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());
    }

    @Test
    public void createUserWithEmptyValues() {
        UserDataDTO userData = FakeUserData.createUserWithEmptyValues();
        Response response = userService.registerNewUser(userData);

        assertEquals(response.getStatusCode(), HttpStatusCode.BAD_REQUEST.getCode());

    }

    @Test(dependsOnMethods = "createUser")
    public void loginCreatedUser() {

        Response response = loginService.loginCreatedUser(createdUser);
        loginUser = response.then().extract().as(LoginResponseDTO.class);

        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());
        assertNotNull(loginUser.getToken());
    }

    @Test
    public void loginNotAuthorizedUser() {
        UserDataDTO nonAuthorizedUser = FakeUserData.createUserData();
        Response response = loginService.loginCreatedUser(nonAuthorizedUser);

        assertEquals(response.getStatusCode(), HttpStatusCode.UNAUTHORIZED.getCode());
    }

    @Test(dependsOnMethods = {"loginCreatedUser", "createUser"})
    public void addToCart() {
        Response response = shoppingCartService.addToCart(loginUser.getUserDTO().getUserId(), BOOK_ID);

        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());
        assertNotEquals(response.getBody().asString(), "");
    }

    @Test
    public void addToCartNegativeUserId() {
        Response response = shoppingCartService.addToCart(-1, -1);
        assertEquals(response.getStatusCode(), HttpStatusCode.NOT_FOUND.getCode());
    }

    @Test(dependsOnMethods = {"loginCreatedUser", "createUser", "addToCart"})
    public void checkUserCart() {
        Response response = shoppingCartService.checkUserCart(loginUser.getUserDTO().getUserId());
        cart = response.jsonPath().getList("", ShoppingCartResponseDTO.class);
        orderDetails = response.jsonPath().getList("", OrderDetailsDTO.class);

        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());
        assertNotNull(cart);
        assertEquals(cart.get(0).getBook().getBookId(), BOOK_ID);
    }

    @Test
    public void checkCartWithUnExistUserId() {
        Response response = shoppingCartService.checkUserCart(-1);

        assertEquals(response.getStatusCode(), HttpStatusCode.NOT_FOUND.getCode());
    }

    @Test(dependsOnMethods = {"loginCreatedUser", "createUser", "addToCart", "checkUserCart"})
    public void checkOut() {
        CheckOutService checkOutService = new CheckOutService();
        Response response = checkOutService.checkOut(loginUser, FakeUserData.createOrderDTO(orderDetails));

        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());
    }

    @Test(dependsOnMethods = {"loginCreatedUser", "createUser", "addToCart", "checkUserCart"})
    public void checkOutEmptyToken() {
        CheckOutService checkOutService = new CheckOutService();
        Response response = checkOutService.checkOutNonHeader(loginUser, FakeUserData.createOrderDTO(orderDetails));

        assertEquals(response.getStatusCode(), HttpStatusCode.UNAUTHORIZED.getCode());
    }
}
