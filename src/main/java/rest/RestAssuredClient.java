package rest;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import rest.commons.ProtocolCodes;

import static io.restassured.RestAssured.given;

public class RestAssuredClient {
 //   RestAssuredConfig rac= RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation("TLSv1.2"));
    public RestAssuredAuthentication getRestAssuredAuthentication(){
        return new RestAssuredAuthentication();}
    public Response doGet(String uri, int expectCode){
        Response response =null;
        try {
            response = given().log().all().contentType(ContentType.JSON).get(uri);
            response.then().statusCode(expectCode);

        } catch (Error error){
            error.printStackTrace();
        }
        return response;
    }
}
