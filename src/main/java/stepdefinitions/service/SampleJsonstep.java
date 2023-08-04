package stepdefinitions.service;

import io.cucumber.java.en.Given;
import com.jayway.jsonpath.JsonPath;

import java.util.Map;

public class SampleJsonstep {
    private Map<String, Object> testData;

    @Given("I have the following test data")
    public void iHavetheFollowingData(String jsonData){
        String test= JsonPath.parse(jsonData).read("$.users[0].name");
       // JsonPath.parse(jsonData).re
        System.out.println(test);
    }

}
