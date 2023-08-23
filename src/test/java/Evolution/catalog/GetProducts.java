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

public class GetProducts {
    private String authToken;

    @BeforeMethod // Получение токена из файла перед каждым тестом
    public void setup() {
        authToken = TokenManager.readTokenFromFile();
    }

    @Test // Получение списка товаров, с учетом условий фильтрации
    public void Get_Products() {

        int categoryId = 4; // Идентификатор категории
        int limit = 2; // Количество элементов, запрашиваемых на страницу
        int page = 1; // Номер запрашиваемой страницы
        String filter = "filter%5Bbrand%5D%3Dapple%2Casus%26filter%5Bavailable%5D%3Dtrue%26filter%5Bprice%5D%3D10000%2C20000";

        API.Specifications.installSpecification(API.Specifications.requestSpec(Constants.BASE_URL), Specifications.responseSpecUnique(200));
        ValidatableResponse response = given()
                    .header("X-Auth-Token", authToken) // Добавляем токен в заголовок
                    .header("accept", "application/json")
                .when()
                    .get("/products?"+categoryId+"&"+filter+"&sortBy=rating-desc&"+page+"&"+limit)
                .then().log().all().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schemas/products-response-schema.json")));

    }
}