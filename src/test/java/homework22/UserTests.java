package homework22;

import homework22.dto.CreateUserDTO;
import homework22.dto.CreateUserResponseDTO;
import homework22.dto.SingleUserResponseDTO;
import homework22.services.UserService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

public class UserTests {
    private static final UserService userService = new UserService();
    private static final Random random = new Random();
    private static final int USER_ID = 2;
    private static final int USER_NOT_FOUND_ID = 23;

    @Test
    public void getSingleUser() {
        Response response = userService.getSingleUser(USER_ID);

        SingleUserResponseDTO singleUserResponseDTO = response
                .then()
                .statusCode(HttpStatusCode.OK.getCode())
                .extract().body().as(SingleUserResponseDTO.class);

        assertEquals(singleUserResponseDTO.getSingleUserData().getId(), USER_ID);
        assertNotNull(singleUserResponseDTO.getSingleUserData().getEmail());
    }

    @Test
    public void getSingleUserNotFound() {
        Response response = userService.getSingleUser(USER_NOT_FOUND_ID);

        SingleUserResponseDTO singleUserNotFound = response
                .then()
                .statusCode(HttpStatusCode.NOT_FOUND.getCode())
                .extract().body().as(SingleUserResponseDTO.class);

        assertNull(singleUserNotFound.getSingleUserData());
    }

    @Test
    public void createUser() {
        CreateUserDTO expectedUserData = FakeUserData.createUserData();
        Response response = userService.createUser(expectedUserData);

        CreateUserResponseDTO createUser = response
                .then()
                .statusCode(HttpStatusCode.CREATED.getCode())
                .extract().as(CreateUserResponseDTO.class);

        assertEquals(createUser.getName(), expectedUserData.getName());
        assertEquals(createUser.getJob(), expectedUserData.getJob());
    }

    @Test
    public void deleteUser() {
        userService.deleteUser(random.nextInt(50) + 1)
                .then()
                .statusCode(HttpStatusCode.NO_CONTENT.getCode());
    }
}
