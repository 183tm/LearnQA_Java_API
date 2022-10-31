import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CookieTest {

    @Test
    public void cockiesTest() {

        Response response = RestAssured
                .given()
                .when()
                .get("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();

        assertEquals("hw_value", response.getCookie("HomeWork"));
        System.out.println(response.getCookies());
    }
}