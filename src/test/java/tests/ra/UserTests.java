package tests.ra;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import keywords.back.User;
import models.UserModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests extends BaseTest {
    private final User user = new User();

    @Test
    @DisplayName("create user and verify it")
    public void createUser() {

        UserModel[] userModel = new UserModel[1];
        Faker testUser = new Faker();
        userModel[0] = UserModel.builder()
                .email(testUser.internet().emailAddress())
                .firstName(testUser.name().firstName())
                .lastName(testUser.name().lastName())
                .password(testUser.internet().password())
                .username(testUser.name().username())
                .phone(testUser.phoneNumber().cellPhone())
                .build();


        Response createdUser = user.create(userModel);
        assertEquals("ok", createdUser.body().jsonPath().getString("message"));

        Response validateUser = user.checkByUsername(userModel[0].getUsername());

        assertEquals(validateUser.jsonPath().getString("username"), userModel[0].getUsername());
        assertEquals(validateUser.jsonPath().getString("firstName"), userModel[0].getFirstName());
        assertEquals(validateUser.jsonPath().getString("lastName"), userModel[0].getLastName());

        Response badUser = user.checkByUsername("UserName", 404);

        assertEquals("User not found", badUser.body().jsonPath().getString("message"));

    }
}
