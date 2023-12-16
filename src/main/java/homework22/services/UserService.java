package homework22.services;

import homework22.dto.CreateUserDTO;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserService extends BaseService {
    private static final String userPath = "/users/";

    public Response getSingleUser(int id) {
        return setRequestSpec()
                .given()
                .when()
                .get(userPath + id);
    }

    public Response createUser(CreateUserDTO user) {
        return setRequestSpec()
                .given()
                .body(user)
                .when()
                .post(userPath);
    }

    public Response deleteUser(int id) {
        return setRequestSpec()
                .given()
                .when()
                .delete(userPath + id);
    }
}
