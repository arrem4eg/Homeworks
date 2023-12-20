package homework23.api.services;

import homework23.api.dto.UserDataDTO;
import io.restassured.response.Response;

public class LoginService extends BaseService {
    private static final String LOGIN_PATH = "/Login";
    public Response loginCreatedUser(UserDataDTO user) {
        return setRequestSpec()
                .given()
                .body(user)
                .post(LOGIN_PATH);
    }
}
