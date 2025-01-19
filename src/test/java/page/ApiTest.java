package page;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.BeforeScenario;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTest {


    private Response response;

    @Step("Bir GET isteği gönder")
    public void sendGetRequest() {
        response = RestAssured.get("https://generator.swagger.io/#/clients/getClientOptions/gen/clients");
    }

    @Step("HTTP durum kodu 200 kontrolü yapılır")
    public void verifyStatusCode200() {
        assertEquals(200, response.getStatusCode());
    }

}
