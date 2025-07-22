package helpers;

import config.BrowserStackConfig;
import config.ConfigProvider;

import static io.restassured.RestAssured.given;

public class Browserstack {

    // curl -u "qaguru_ti9G5S:5yrxu4nFTKkRExUAhqxh" -X GET "https://api.browserstack.com/app-automate/sessions/0359d759d2aaa4f46401dac46bd281b6d9b24943.json"
    // automation_session.video_url

    protected static final BrowserStackConfig config = ConfigProvider.getConfiguredDriver();

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(config.userName(), config.accessKey())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
