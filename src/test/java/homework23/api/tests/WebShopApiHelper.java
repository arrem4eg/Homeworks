package homework23.api.tests;

import homework23.api.dto.LoginResponseDTO;
import homework23.api.dto.OrderDetailsDTO;
import homework23.api.dto.ShoppingCartResponseDTO;
import homework23.api.dto.UserDataDTO;
import homework23.api.services.LoginService;
import homework23.api.services.ShoppingCartService;
import homework23.api.services.UserService;

import java.util.List;

public abstract class WebShopApiHelper {
    static UserService userService = new UserService();
    static final LoginService loginService = new LoginService();
    static final ShoppingCartService shoppingCartService = new ShoppingCartService();
    static UserDataDTO createdUser;
    static LoginResponseDTO loginUser;
    static List<ShoppingCartResponseDTO> cart;
    static List<OrderDetailsDTO> orderDetails;
    static final int BOOK_ID = 5;
}
