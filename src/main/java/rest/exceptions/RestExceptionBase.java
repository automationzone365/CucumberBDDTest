package rest.exceptions;

import rest.RestAssuredClient;

public class RestExceptionBase extends RuntimeException {

    public RestExceptionBase(String message, Throwable ex){
        super(getMessageEx(message,ex),ex);
    }

    public RestExceptionBase(String message){
        super(getMessageEx(message,null));
    }

    private static String getMessageEx(String message, Throwable ex) {
        if(ex!=null && ex instanceof RestExceptionBase){
            return "\n\tMessage ="+message;
        }
        return "\n\tException ="+ message
                 + "\n\tException = "+ ex;
    }
}
