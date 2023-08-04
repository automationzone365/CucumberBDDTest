package rest;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import rest.commons.ProtocolCodes;
import rest.exceptions.RestCallException;

import static io.restassured.RestAssured.expect;
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
    public Response doPost(
            String uri, String payload, Headers headers, int expectCode, boolean... ignoreError){
      Response response = null;
      try{
          response=given()
                        .log()
                        .all()
                        .contentType(ContentType.JSON)
                        .headers(headers)
                        .body(payload)
                        .post(uri);
          response.then().statusCode(expectCode);
      } catch(Error error){
          if(ignoreError.length>0 && ignoreError[0]) {
          } else if(ignoreError.length>0
               && ignoreError[0]
               && (response.getStatusCode()== ProtocolCodes.CONFLICT)){
          } else {
              throw new RestCallException(
                  uri,
                  ProtocolCodes.POST,
                  "Error: Failed to perform POST operation."
                     + "\nResponse Code: "
                     +  response.statusCode()
                     + "\nHeaders: "
                     + headers.asList()
                     + "\nPayload: "
                     + payload
                     + "\nResponse: "
                     + response.asString(),
                  error);


          }

      }
        return response;
    }
    public Response doPost(String uri, byte[] payload, Headers headers, int expectCode) {
        Response response =null;
        try {
            response = given().contentType(ContentType.ANY).headers(headers).body(payload).post(uri);
            response.then().statusCode(expectCode);
        }catch (Error error) {
            throw new RestCallException(
                    uri,
                    ProtocolCodes.POST,
                    "Error: Failed to perform POST operation."
                            + "\nResponse Code:"
                            + response.statusCode()
                            + response.statusCode()
                            + "\nPayload: "
                            + payload
                            + "\nResponse: "
                            + response.asString(),
                    error);
            }
            return response;
        }
    }

