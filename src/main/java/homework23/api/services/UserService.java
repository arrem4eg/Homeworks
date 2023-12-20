package homework23.api.services;

import homework23.api.dto.UserDataDTO;
import io.restassured.response.Response;

public class UserService extends BaseService {
    private static final String USER_PATH = "/User";

    public Response registerNewUser(UserDataDTO user) {
        return setRequestSpec()
                .given()
                .body(user)
                .post(USER_PATH);
    }
}
