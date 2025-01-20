package page;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.BeforeScenario;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTest {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    private Response response;

    String id;

    String serviceUrl = "https://petstore.swagger.io";

    @Step("Bir GET isteği gönder")
    public void sendGetRequest() {
        response = RestAssured.given()
                .header("Content-Type", "application/json").get(serviceUrl + "/v2/pet/" + id);
    }

    @Step("HTTP durum kodu 200 kontrolü yapılır")
    public void verifyStatusCode200() {
        assertEquals(200, response.getStatusCode(), "Durum kodu 200 olmalıdır.");
    }


    @Step("Bir POST isteği gönder")
    public void sendPostRequest() {
        id = "999";
        String requestBody = """
            {
                 "id": %s,
                 "category": {
                 "id": 20,
                 "name": "Sirius"
                 }
           }
        """.formatted(id);

        response = RestAssured.given()
                .baseUri(serviceUrl + "/v2")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("/pet");

        response.then().log().all();

    }

    @Step("Yanıt verisi kontrol edilir")
    public void verifyResponse() {
        logger.info("Yanit Govdesi: {}", response.getBody().asString());
        logger.info("Yanit Sonucu: {}", response.getStatusCode());
    }


}
