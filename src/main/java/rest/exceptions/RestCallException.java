package rest.exceptions;

import io.restassured.RestAssured;

public class RestCallException extends RestExceptionBase{
    public RestCallException(String uri, String type, String message, Throwable ex){
        super("\n\tUrl      ==> "+(uri.startsWith("http")? uri:
                RestAssured.baseURI.endsWith("/")?RestAssured.baseURI:RestAssured.baseURI+"/"+uri)
                + "\n\tType         ==>"+ type
                + message
                + "\n\n"
                ,ex);

    }
}
