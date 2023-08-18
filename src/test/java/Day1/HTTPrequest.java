package Day1;

/*
given()
    content type, set cookies, add auth, add param, set headers info

when()
    get, post, put, delete

then()
    validate status code, extract response, extract headers cookies & response body
*/

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HTTPrequest {

    int id;

    @Test (priority=1)
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

    @Test(priority = 2)
    void createUser() {
        HashMap data = new HashMap<>();
        data.put("name", "pavan");
        data.put("job", "trainer");

        id = given()
                    .contentType("application/json")
                    .body(data)
                .when()
                    .post("https://reqres.in/api/users")
                .then()
                    .statusCode(201)
                    .extract().jsonPath().getInt("id");

        System.out.println("Created user with ID: " + id);
    }

    @Test (priority=3,dependsOnMethods = {"createUser"})
    void updateUser()
    {
        HashMap data = new HashMap<>();
        data.put("name","pavan1");
        data.put("job","trainer1");

        given()
                .contentType("application/json")
                .body(data)

                .when()
                    .put("https://reqres.in/api/users/"+id)

                .then()
                    .statusCode(200)
                    .log().all();

        System.out.println("Update user with ID: " + id);

    }

    @Test (priority=4,dependsOnMethods = {"createUser"})
    void deleteUser()
    {
        given()

                .when()
                    .delete("https://reqres.in/api/users/"+id)

                .then()
                    .statusCode(204)
                    .log().all();


    }

    @Test (priority=5,dependsOnMethods = {"deleteUser"})
    void UserNotFound()
    {
        given()

                .when()
                .get("https://reqres.in/api/users/"+id)

                .then()
                .statusCode(404)
                .log().all();


    }


}
