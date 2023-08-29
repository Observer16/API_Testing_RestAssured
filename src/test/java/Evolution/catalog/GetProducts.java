package Evolution.catalog;

import Evolution.utils.service.Specifications;
import Evolution.utils.pojos.products.Products;
import Evolution.utils.pojos.products.Root;
import Evolution.utils.service.Constants;
import Evolution.utils.service.TokenManager;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.util.List;
import static io.restassured.RestAssured.given;
import Evolution.utils.service.HeaderUtils;

public class GetProducts {
    private String authToken;

    @BeforeMethod // Получение токена из файла перед каждым тестом
    public void setup() {
        authToken = TokenManager.readTokenFromFile();
    }

    @Test // Получение списка товаров, с учетом условий фильтрации
    public void Get_Products() {

        int sectionId = 29180; // Идентификатор категории
        int limit = 1; // Количество элементов, запрашиваемых на страницу
        int page = 1; // Номер запрашиваемой страницы
        String filter = "filter%5Bbrand%5D%3Dapple%2Casus%26filter%5Bavailable%5D%3Dtrue%26filter%5Bprice%5D%3D10000%2C20000";

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL), Specifications.responseSpecUnique(200));

        // Создание заголовков с использованием HeaderUtils
        Headers headers = HeaderUtils.createHeaders(authToken);

        ValidatableResponse response = given()
                .headers(headers)
                .when()
                    .get("/products?sectionId="+sectionId+"&storeIds=325%2C673358&viewMode=products&sortBy=pop-desc&"+page+"&limit="+limit)
                .then().log().all().assertThat()
                    .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schemas/products-schema.json")));
    }

    @Test // Проверка, что у товара есть картинка
    public void Checking_product_image() {

        int sectionId = 29180; // Идентификатор категории
        int limit = 1; // Количество элементов, запрашиваемых на страницу
        int page = 1; // Номер запрашиваемой страницы
        String filter = "filter%5Bbrand%5D%3Dapple%2Casus%26filter%5Bavailable%5D%3Dtrue%26filter%5Bprice%5D%3D10000%2C20000";

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL), Specifications.responseSpecUnique(200));

        // Создание заголовков с использованием HeaderUtils
        Headers headers = HeaderUtils.createHeaders(authToken);

        Response response = given()
                .headers(headers)
                .when()
                .get("/products?sectionId="+sectionId+"&storeIds=325%2C673358&viewMode=products&sortBy=pop-desc&"+page+"&limit="+limit)
                .then().assertThat().log().all()
                .extract().response();

        Root productResponse = response.as(Root.class);
        List<Products> products = productResponse.getData().getProducts();
        Assert.assertTrue(products.stream().allMatch(x -> x.getImages().stream().allMatch(image -> image.getPath().endsWith(".jpg"))));

    }
}