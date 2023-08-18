package Day1;

/*
given()
    content type, set cookies,

when()
    get, post, put, delete

then()
    validate status code

*/

import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class HTTPRequest {

    @Test
    void getUsers()

    {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")

                .then()
                .statusCode(200);


    }


}
