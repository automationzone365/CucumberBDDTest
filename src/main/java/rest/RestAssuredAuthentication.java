package rest;

import io.restassured.RestAssured;
import rest.commons.ProtocolCodes;

import static io.restassured.RestAssured.*;
import static io.restassured.authentication.FormAuthConfig.formAuthConfig;

public class RestAssuredAuthentication {
    public void preemeptiveBasicLogin(String userName, String password) {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.authentication = preemptive().basic(userName, password);
    }

    public void loginForm(String url, String userName, String password){
        RestAssured.useRelaxedHTTPSValidation();
        given().auth().form(userName,password, formAuthConfig().withAutoDetectionOfCsrf()).when().get(url)
                .then().statusCode(ProtocolCodes.OK);
    }

    public void loginOauth2(String accessToken){
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.authentication =oauth2(accessToken);
    }
}
