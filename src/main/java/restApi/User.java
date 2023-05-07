package restApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class User {
    public User() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
    }

    public Response registerNewUser(String email, String password, String name){

        return given()
                .header("Content-type", "application/json")
                .body(String.format("{\"email\": \"%s\", \"password\": \"%s\", \"name\": \"%s\"}", email, password, name))
                .when()
                .post("/api/auth/register");
    }
    public Response deleteUser(String email, String password){
        String accessToken = "";
        Response loginResp = given()
                .header("Content-type", "application/json")
                .body(String.format("{\"email\": \"%s\", \"password\": \"%s\"}", email, password ))
                .when()
                .post("/api/auth/login");

        if (loginResp.then().extract().path("success")) {
            accessToken = loginResp.then().extract().path("accessToken").toString().substring(7);
        }

        return given()
                .header("Content-type", "application/json")
                .auth().oauth2(accessToken)
                .when()
                .delete("/api/auth/user");

    }
}
