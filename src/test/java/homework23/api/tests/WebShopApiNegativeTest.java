package homework23.api.tests;

import homework23.api.dto.LoginResponseDTO;
import homework23.api.dto.UserDataDTO;
import homework23.api.services.CheckOutService;
import homework23.api.utils.FakeUserData;
import homework23.api.utils.HttpStatusCode;
import homework23.listeners.ApiTestListener;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(ApiTestListener.class)
public class WebShopApiNegativeTest extends WebShopApiHelper {

    @Test
    public void createUserWithEmptyValues() {
        UserDataDTO userData = FakeUserData.createUserWithEmptyValues();
        Response response = userService.registerNewUser(userData);

        assertEquals(response.getStatusCode(), HttpStatusCode.BAD_REQUEST.getCode());
    }

    @Test
    public void loginNotAuthorizedUser() {
        UserDataDTO nonAuthorizedUser = FakeUserData.createUserData();
        Response response = loginService.loginCreatedUser(nonAuthorizedUser);

        assertEquals(response.getStatusCode(), HttpStatusCode.UNAUTHORIZED.getCode());
    }

    @Test
    public void addToCartNegativeUserId() {
        Response response = shoppingCartService.addToCart(-1, -1);
        assertEquals(response.getStatusCode(), HttpStatusCode.NOT_FOUND.getCode());
    }

    @Test
    public void checkCartWithUnExistUserId() {
        Response response = shoppingCartService.checkUserCart(-1);

        assertEquals(response.getStatusCode(), HttpStatusCode.NOT_FOUND.getCode());
    }

    @Test
    public void checkOutEmptyToken() {
        createdUser = FakeUserData.createUserData();
        userService.registerNewUser(createdUser);
        Response responseLogin = loginService.loginCreatedUser(createdUser);
        loginUser = responseLogin.then().extract().as(LoginResponseDTO.class);
        shoppingCartService.addToCart(loginUser.getUserDTO().getUserId(), BOOK_ID);

        CheckOutService checkOutService = new CheckOutService();
        Response response = checkOutService.checkOutNonHeader(loginUser, FakeUserData.createOrderDTO(orderDetails));

        assertEquals(response.getStatusCode(), HttpStatusCode.UNAUTHORIZED.getCode());
    }
}
