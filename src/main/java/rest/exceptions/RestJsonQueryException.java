package rest.exceptions;

public class RestJsonQueryException extends RestExceptionBase{
    public RestJsonQueryException(String jsonString, String path, String key,Throwable ex) {
        super("\n\tError = Json query failed..."
                        + "\n\tGiven Json = " + jsonString
                        + "\n\tLooking for path = "+path
                        + "\n\tKey under path = "+ key
                        + "\n\n"
                  ,ex
        );
    }
    public RestJsonQueryException(String jsonString, String path,Throwable ex) {
        super("\n\tError = Json query failed..."
                        + "\n\tGiven Json = " + jsonString
                        + "\n\tLooking for path = "+path
                        + "\n\n"
                ,ex
        );
    }
    public RestJsonQueryException(String jsonString, String path,String key) {
        super("\n\tError = Json query failed..."
                        + "\n\tGiven Json = " + jsonString
                        + "\n\tLooking for path = "+path
                        + "\n\tKey under path =" + key
                        + "\n\n"
        );
    }
}
