package keywords.back;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.UserModel;

public class User {
    public Response create(UserModel[] userModel) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(userModel)
                .log().ifValidationFails()
                .log().body()

                .when()
                .post("/user/createWithArray")

                .then()
                .log().ifValidationFails()
                .statusCode(200)

                .extract()
                .response();
    }

    public Response checkByUsername(String username, int statusCode) {
        return RestAssured
                .given()
                .pathParam("userName", username)

                .log().ifValidationFails()
                .log().uri()

                .when()
                .get("/user/{userName}")

                .then()
                .statusCode(statusCode)
                .log().ifValidationFails()
                .log().body()

                .extract()
                .response();
    }

    public Response checkByUsername(String username) {
        return checkByUsername(username, 200);
    }
}
