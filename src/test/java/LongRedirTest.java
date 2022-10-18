import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class LongRedirTest {

    @Test
    public void longTest() {

        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        String responseHeader = String.valueOf(response.getHeader("Location"));
        System.out.println(responseHeader);

        int cod = response.getStatusCode();
        System.out.println(cod);

        while (cod != 200) {

            response = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(String.valueOf(responseHeader))
                    .andReturn();

            responseHeader = response.getHeader("Location");
            System.out.println(responseHeader);

            cod = response.getStatusCode();
            System.out.println(cod);
        }


    }
}