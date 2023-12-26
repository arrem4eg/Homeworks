package homework23.ui.utils;

import com.github.javafaker.Faker;
import homework23.api.dto.UserDataDTO;
import io.restassured.RestAssured;

public class CreateUserApi {
    private static final Faker faker = new Faker();
    public static UserDataDTO createUser() {

       UserDataDTO user = UserDataDTO.builder()
                .userId(0)
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .username(faker.name().username())
                .password(faker.internet().password())
                .gender(faker.options().option("male", "female"))
                .userTypeId(faker.number().numberBetween(1, 100))
                .build();

        RestAssured.given()
                .when()
                .contentType("application/json")
                .body(user)
                .post("https://bookcart.azurewebsites.net/api/User");
        return user;
    }
}
