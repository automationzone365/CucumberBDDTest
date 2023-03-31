package rest.parsers;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import rest.exceptions.RestJsonQueryException;

import java.util.List;

public class RestAssuredJsonParser {
    public static String getJsonValue(Response response, String property){
        try{
            return JsonPath.with(response.asString()).get(property).toString();
        }catch(Exception ex){
            throw new RestJsonQueryException(response.asString(),"Unable to get property from response: "+ex.getMessage(), property);
        }
    }
    public static List<String> getJsonValues(Response response, String property){
        try{
            return JsonPath.with(response.asString()).getList(property);
        } catch(Exception ex){
            throw new RestJsonQueryException(response.asString(),"",property);
        }
    }
}
