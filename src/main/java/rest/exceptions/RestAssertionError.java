package rest.exceptions;

public class RestAssertionError extends RestExceptionBase {
    public RestAssertionError (AssertionError error){
        super("REST Assertion Failed...", error);
    }
}
