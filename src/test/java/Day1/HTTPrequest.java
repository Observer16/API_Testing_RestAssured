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
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

// import static io.restassured.RestAssured.given;
// import static io.restassured.RestAssured.when;
// import static org.hamcrest.core.IsEqual.equalTo;

public class HTTPrequest {

    @Test
    void getUsers()

    {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")

                .then()
                .statusCode(200)
                .body("page",equalTo(2))
                .log().all();


    }


}
