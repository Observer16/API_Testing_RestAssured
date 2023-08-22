package API;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.time.Clock;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    private final static String URL = "https://reqres.in";

    @Test(priority = 1)  // проверка почты и аватара
    public void CheckAvatarAndIdTest() {

        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        List<UserData> users = given()
                .when()
                //.contentType(ContentType.JSON)
                .get("/api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        // У каждого пользователя прошел перебор с получением аватара и сравнили, что ID содержится в аватаре
        users.forEach(x -> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));

        // проверяем всех пользователей у которых присутствует почта @reqres.in
        Assert.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));

        // проверим аватарки
        List<String> avatars = users.stream().map(UserData::getAvatar).toList();

        // проверим ID
        List<String> id = users.stream().map(x -> x.getId().toString()).toList();

        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(avatars.get(i).contains(id.get(i)));
        }

    }

    @Test(priority = 2) // Тест успешной регистрации
    public void successRegTest() {
        // Установка спецификаций запроса и ответа
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());

        // Подготовка данных для запроса
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");

        // Отправка запроса на регистрацию пользователя и получение ответа
        SuccessReg successReg = given()
                .body(user)
                .when()
                .post("/api/register")
                .then().log().all() // Логирование всего ответа
                .extract().as(SuccessReg.class);

        // Проверка соответствия ID и токена в ответе ожидаемым значениям
        Assert.assertEquals(id, successReg.getId());
        Assert.assertEquals(token, successReg.getToken());
    }

    @Test(priority = 3)  // проверяем, что нет заполненного пароля и получаем code 400
    public void unSuccessRegTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecError400());
        Register user = new Register("sydney@fife", "");
        UnSuccessReg unSuccessReg = given()
                .body(user)
                .post("/api/register")
                .then().log().all()
                .extract().as(UnSuccessReg.class);
        Assert.assertEquals("Missing password", unSuccessReg.getError());

    }

    @Test(priority = 4) // проверка сортировки по годам
    public void sortedYearsTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        List<ColorsData> colors = given()
                .when()
                .get("/api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ColorsData.class);
        List<Integer> years = colors.stream().map(ColorsData::getYear).collect(Collectors.toList());
        List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(sortedYears, years);
        System.out.println(years);
        System.out.println(sortedYears);

    }

    @Test(priority = 5) // проверка удаления
    public void deleteUserTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(204));
        given()
                .when()
                .delete("/api/users/2")
                .then().log().all();

    }

    @Test(priority = 6) // проверка времени
    public void timeTest1() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        UserTime user = new UserTime("morpheus", "zion resident");
        UserTimeResponse response = given()
                .body(user)
                .when()
                .put("/api/users/2")
                .then().log().all()
                .extract().as(UserTimeResponse.class);

        String regex = "(.{6})$";
        String regex1 = "(.{12})$";
        String currentTime = Clock.systemUTC().instant().toString().replaceAll(regex1, "");
        System.out.println(currentTime);
        Assert.assertEquals(currentTime, response.getUpdatedAt().replaceAll(regex, ""));
        System.out.println(response.getUpdatedAt().replaceAll(regex, ""));

    }

    @Test(priority = 7) // проверка времени с переводом в секунды
    public void timeTest2() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        UserTime user = new UserTime("morpheus", "zion resident");
        UserTimeResponse response = given()
                .body(user)
                .when()
                .put("/api/users/2")
                .then().log().all()
                .extract().as(UserTimeResponse.class);

        Instant currentTime = Clock.systemUTC().instant();
        Instant serverTime = Instant.parse(response.getUpdatedAt());

        long currentTimeMillis = currentTime.toEpochMilli();
        long serverTimeMillis = serverTime.toEpochMilli();

        // Получаем первые 8 цифр с помощью регулярного выражения
        String currentTimeFirstDigits = String.valueOf(currentTimeMillis).substring(0, 9);
        String serverTimeFirstDigits = String.valueOf(serverTimeMillis).substring(0, 9);

        System.out.println(currentTimeFirstDigits);
        System.out.println(serverTimeFirstDigits);

        Assert.assertEquals(currentTimeFirstDigits, serverTimeFirstDigits);
    }


}