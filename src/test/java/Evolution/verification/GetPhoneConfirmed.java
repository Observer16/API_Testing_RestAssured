package Evolution.verification;

import Evolution.utils.service.Constants;
import Evolution.utils.service.HeaderUtils;
import Evolution.utils.service.Specifications;
import Evolution.utils.service.TokenManager;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;

import static io.restassured.RestAssured.given;

public class GetPhoneConfirmed {
    private String authToken;

    @BeforeMethod // Получение токена из файла перед каждым тестом
    public void setup() {
        authToken = TokenManager.readTokenFromFile();
    }

    @Test // Проверка подтвержденного номера телефона
    public void GetPhoneConfirmed() {

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL), Specifications.responseSpecUnique(200));
        // Создание заголовков с использованием HeaderUtils
        Headers headers = HeaderUtils.createHeaders(authToken);

        ValidatableResponse response = given()
                .headers(headers)
                .when()
                .get("/phone/is-confirmed?phone=79234567890&scenario=registration")
                .then().log().all().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schemas/phone-schema.json")));
    }

}
