package homework23.api.utils;

import com.github.javafaker.Faker;
import homework23.api.dto.*;

import java.util.List;

public class FakeUserData {
    private static final Faker faker = new Faker();

    public static UserDataDTO createUserData() {
        return UserDataDTO.builder()
                .userId(0)
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .username(faker.name().username())
                .password(faker.internet().password())
                .gender(faker.options().option("male", "female"))
                .userTypeId(faker.number().numberBetween(1, 100))
                .build();
    }

    public static UserDataDTO createUserWithEmptyValues() {
        return UserDataDTO.builder()
                .userId(0)
                .firstName("")
                .lastName("")
                .username("")
                .password("")
                .gender("")
                .userTypeId(-1)
                .build();
    }

    public static CheckOutDTO createOrderDTO(List<OrderDetailsDTO> orderDetails) {
        return CheckOutDTO
                .builder()
                .orderId(String.valueOf(faker.number().numberBetween(1000, 9000)))
                .orderDetails(orderDetails)
                .cartTotal(1)
                .orderDate("2023-12-18T20:41:07.108Z")
                .build();
    }
}
