package Evolution.catalog;

import API.Specifications;
import Evolution.service.Constants;
import Evolution.service.TokenManager;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class GetViewedProducts {
    private String authToken;

    @BeforeMethod // Получение токена из файла перед каждым тестом
    public void setup() {
        authToken = TokenManager.readTokenFromFile();
    }

    @Test // Получение списка ранее просмотренных товаров
    public void Get_Viewed_Products() {

        API.Specifications.installSpecification(API.Specifications.requestSpec(Constants.BASE_URL), Specifications.responseSpecUnique(200));
        ValidatableResponse response = given()
                    .header("X-Auth-Token", authToken) // Добавляем токен в заголовок
                    .header("accept", "application/json")
                .when()
                    .get("/viewed-products")
                .then().log().all().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schemas/viewedproducts-response-schema.json")));

    }
}