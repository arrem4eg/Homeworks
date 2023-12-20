package homework23.api.services;

import homework23.api.dto.LoginResponseDTO;
import homework23.api.dto.CheckOutDTO;
import io.restassured.response.Response;

public class CheckOutService extends BaseService {
    private static final String CHECK_OUT_PATH = "/CheckOut/";

    public Response checkOut(LoginResponseDTO login, CheckOutDTO checkOut) {
        return setRequestSpec()
                .given()
                .header("Authorization", "Bearer " + login.getToken())
                .body(checkOut)
                .post(CHECK_OUT_PATH + login.getUserDTO().getUserId());
    }

    public Response checkOutNonHeader(LoginResponseDTO login, CheckOutDTO checkOut) {
        return setRequestSpec()
                .given()
                .body(checkOut)
                .post(CHECK_OUT_PATH + login.getUserDTO().getUserId());
    }
}
