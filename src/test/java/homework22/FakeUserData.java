package homework22;

import com.github.javafaker.Faker;
import homework22.dto.CreateUserDTO;

public class FakeUserData {
        public static CreateUserDTO createUserData() {
        Faker faker = new Faker();
        return CreateUserDTO.builder()
                .name(faker.name().firstName())
                .job(faker.job().title())
                .build();
    }
}
