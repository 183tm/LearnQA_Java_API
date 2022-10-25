import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TokenTest {

    @Test
    public void tokTest() throws InterruptedException {

        JsonPath response = RestAssured

                .given()
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        response.prettyPrint();
        String token = response.get("token");

        JsonPath beforeReq = RestAssured

                .given()
                .param("token", token)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        String tok = beforeReq.get("status");
        beforeReq.prettyPrint();
        Assertions.assertEquals("Job is NOT ready", tok);

        if (tok.equals("Job is NOT ready")) {

            int time = response.get("seconds");
            Thread.sleep(time*1000L);}

            JsonPath afterReq = RestAssured

                    .given()
                    .param("token", token)
                    .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                    .jsonPath();

            tok = afterReq.get("status");
            afterReq.prettyPrint();
            Assertions.assertEquals("Job is ready", tok);
            String result = afterReq.get("result");
            Assertions.assertNotNull(result);

        }

}
