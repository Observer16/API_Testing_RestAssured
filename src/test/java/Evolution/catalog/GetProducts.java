package Evolution.catalog;

import API.Specifications;
import Evolution.utils.service.Constants;
import Evolution.utils.service.TokenManager;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;
import Evolution.utils.HeaderUtils;

public class GetProducts {
    private String authToken;

    @BeforeMethod // Получение токена из файла перед каждым тестом
    public void setup() {
        authToken = TokenManager.readTokenFromFile();
    }

    @Test // Получение списка товаров, с учетом условий фильтрации
    public void Get_Products() {

        int sectionId = 29180; // Идентификатор категории
        int limit = 2; // Количество элементов, запрашиваемых на страницу
        int page = 1; // Номер запрашиваемой страницы
        String filter = "filter%5Bbrand%5D%3Dapple%2Casus%26filter%5Bavailable%5D%3Dtrue%26filter%5Bprice%5D%3D10000%2C20000";

        API.Specifications.installSpecification(API.Specifications.requestSpec(Constants.BASE_URL), Specifications.responseSpecUnique(200));

        // Создание заголовков с использованием HeaderUtils
        Headers headers = HeaderUtils.createHeaders(authToken);

        ValidatableResponse response = given()
                .headers(headers)
                .when()
                    .get("/products?sectionId="+sectionId+"&storeIds=325%2C673358&viewMode=products&sortBy=pop-desc&"+page+"&limit="+limit)
                .then().log().all().assertThat()
                    .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schemas/products-schema.json")));

    }
}