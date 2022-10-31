import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeadersTest {

    @Test
    public void headerTest() {

        Response response = RestAssured
                .given()
                .log().all()
                .when()
                .get("https://playground.learnqa.ru/api/homework_header")
                .andReturn();

        assertEquals("Apache", response.getHeader("server"));
        assertEquals("15", response.getHeader("content-length"));
        assertEquals("Some secret value", response.getHeader("x-secret-homework-header"));
        System.out.println(response.getHeaders());
    }

}
