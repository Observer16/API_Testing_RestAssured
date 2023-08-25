package Evolution.catalog;

import API.Specifications;
import Evolution.utils.pojos.catalog.CatalogCategory;
import Evolution.utils.pojos.catalog.CatalogRoot;
import Evolution.utils.service.Constants;
import Evolution.utils.service.TokenManager;
import Evolution.utils.HeaderUtils;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetCategories {
    private String authToken;

    @BeforeMethod // Получение токена из файла перед каждым тестом
    public void setup() {
        authToken = TokenManager.readTokenFromFile();
    }

    @Test // Получение каталога товаров, а точнее иерархии категорий
    public void Get_Categories() {
        API.Specifications.installSpecification(API.Specifications.requestSpec(Constants.BASE_URL), Specifications.responseSpecUnique(200));
        int sectionId = 29705;
        // Создание заголовков с использованием HeaderUtils
        Headers headers = HeaderUtils.createHeaders(authToken);

        ValidatableResponse response = given()
                .headers(headers)
                .when()
                    .get("/categories?sectionId="+sectionId)
                .then().log().all().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schemas/categories-schema.json")));
    }

    @Test // Проверка присутствия картинки категории
    public void PresenceCategoryPicture() {
        API.Specifications.installSpecification(API.Specifications.requestSpec(Constants.BASE_URL), Specifications.responseSpecUnique(200));
        int sectionId = 29705;
        // Создание заголовков с использованием HeaderUtils
        Headers headers = HeaderUtils.createHeaders(authToken);

        Response response = given()
                .headers(headers)
                .when()
                .get("/categories?sectionId=" + sectionId)
                .then().log().all().assertThat()
                .extract().response();

        CatalogRoot catalogResponse = response.as(CatalogRoot.class);

        List<CatalogCategory> categories = catalogResponse.getData().getCategories();
        Assert.assertTrue(categories.stream().allMatch(x -> x.getMedia().getPath().endsWith(".jpg")));
    }
}