package Day2;
/*
given()
    content type, set cookies, add auth, add param, set headers info

when()
    get, post, put, delete

then()
    validate status code, extract response, extract headers cookies & response body
*/

import Day2.models.Student;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DiffWayToCreatePostRequresBody {


    @Test(priority = 1)
    void testPostusingHashMap()
    {
        List<String> course = new ArrayList<>();
        course.add("Java");
        course.add("Selenium");

        Student student = new Student();
        student.setName("Vitaly");
        student.setLocation("Ukraine");
        student.setPhone("79998787676");
        student.setCourse(course);

        HashMap data = new HashMap();
        data.put("name", "Scott");
        data.put("location", "Ukraine");
        data.put("phone", "79998787676");
        String[] courseArr = new String[]{"C++", "C#"};
        data.put("course", courseArr);

        given()
                .contentType("application/json")
                .body(data)

        .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("Scott"))
                .body("location",equalTo("Ukraine"))
                .body("phone",equalTo("79998787676"))
                .body("course[0]",equalTo("C++"))
                .body("course[1]",equalTo("C#"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all();


    }


}