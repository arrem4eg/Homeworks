package homework23.api.services;

import io.restassured.response.Response;

public class ShoppingCartService extends BaseService {
    private static final String ADD_TO_CART_PATH = "/ShoppingCart/AddToCart/";
    private static final String CHACK_CART = "/ShoppingCart/";

    public Response addToCart(int userId, int bookId) {
        return setRequestSpec()
                .given()
                .body(userId)
                .post(ADD_TO_CART_PATH + userId + "/" + bookId);
    }

    public Response checkUserCart(int userId) {
        return setRequestSpec()
                .given()
                .get(CHACK_CART + userId);
    }
}
