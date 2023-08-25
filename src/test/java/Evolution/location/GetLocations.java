package Evolution.location;

import API.Specifications;
import Evolution.utils.HeaderUtils;
import Evolution.utils.service.Constants;
import Evolution.utils.service.TokenManager;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class GetLocations {
    private String authToken;

    @BeforeMethod // Получение токена из файла перед каждым тестом
    public void setup() {
        authToken = TokenManager.readTokenFromFile();
    }

    @Test // Получение списка городов
    public void Get_Viewed_Products() {

        API.Specifications.installSpecification(API.Specifications.requestSpec(Constants.BASE_URL), Specifications.responseSpecUnique(200));
        // Создание заголовков с использованием HeaderUtils
        Headers headers = HeaderUtils.createHeaders(authToken);

        ValidatableResponse response = given()
                .headers(headers)
                .when()
                .get("/locations")
                .then().log().all().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schemas/locations-schema.json")));

    }
}
