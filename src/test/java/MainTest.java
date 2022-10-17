import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MainTest {

    @Test
    public void testPars(){

        JsonPath response = RestAssured
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();

        List<String> messages = response.getList("messages.message");
        System.out.println(messages.get(1));
    }
}
