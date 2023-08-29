package Evolution.location;

import Evolution.utils.service.Specifications;
import Evolution.utils.service.HeaderUtils;
import Evolution.utils.pojos.locations.LocationLocation;
import Evolution.utils.pojos.locations.LocationRoot;
import Evolution.utils.service.Constants;
import Evolution.utils.service.TokenManager;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.util.List;
import static io.restassured.RestAssured.given;

public class GetLocations {
    private String authToken;

    @BeforeMethod // Получение токена из файла перед каждым тестом
    public void setup() {
        authToken = TokenManager.readTokenFromFile();
    }

    @Test (priority=1) // Получение списка городов
    public void GetListCities() {

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL), Specifications.responseSpecUnique(200));
        // Создание заголовков с использованием HeaderUtils
        Headers headers = HeaderUtils.createHeaders(authToken);

        ValidatableResponse response = given()
                .headers(headers)
                .when()
                .get("/locations")
                .then().log().all().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schemas/locations-schema.json")));

    }

    @Test (priority = 2) // Проверка ID локации
    public void GetIdLocation() {

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL), Specifications.responseSpecUnique(200));

        // Создание заголовков с использованием HeaderUtils
        Headers headers = HeaderUtils.createHeaders(authToken);

        Response response = given()
                .headers(headers)
                .when()
                .get("/locations")
                .then().log().all().extract().response(); // Извлечение объекта Response

        LocationRoot locationResponse = response.as(LocationRoot.class);
        List<LocationLocation> locations = locationResponse.getData().getLocations();

        // Проверка, что все id в списке locations не равны нулю
        Assert.assertTrue(locations.stream().allMatch(location -> location.getId() != 0));
    }


}
