package stepdefinitions;

import context.DriverContext;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import rest.RestAssuredClient;
import rest.commons.ProtocolCodes;
import rest.parsers.RestAssuredJsonParser;
import utils.ConfigLoader;


public class UserdataAPI {
    RestAssuredClient restAssuredClient;

    public UserdataAPI(DriverContext context) {
        restAssuredClient = context.restAssuredClient;
    }

    @Given("I'm a admin to verify a user")
    public void i_m_a_admin_to_verify_a_user() {

        Response res = restAssuredClient.doGet(ConfigLoader.getInstance().getBaseURI() + "/api/users/2", ProtocolCodes.OK);

        System.out.println(RestAssuredJsonParser.getJsonValue(res, "data.id"));

    }

    @Given("I'm a admin to verify single resource")
    public void i_m_a_admin_to_verify_a_single_resource() {

        Response res = restAssuredClient.doGet(ConfigLoader.getInstance().getBaseURI() + "/api/unknown/2", ProtocolCodes.OK);

        System.out.println(RestAssuredJsonParser.getJsonValue(res, "data.name"));

    }

}
