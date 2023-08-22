package Evolution.token;

import Evolution.service.Constants;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import API.Specifications;
import static io.restassured.RestAssured.given;

public class PatchToken {
    String authToken;

    @Test // Обновление токена
    public void PatchAGuestToken() {
        API.Specifications.installSpecification(API.Specifications.requestSpec(Constants.BASE_URL), Specifications.responseSpecUnique(204));
        String platform = "Android 12";
        String version = "2.1.0";
        String build = "Build/SP1A.210812.016";

        ValidatableResponse response = given()
                .when()
                .patch("/auth/token")
                .then().log().all();

        // Извлечение значения токена из заголовков ответа
        String authToken = response.extract().header("X-Auth-Token");
        System.out.println(authToken);
    }
}