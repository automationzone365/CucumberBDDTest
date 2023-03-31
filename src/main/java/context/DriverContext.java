package context;

import domainobjects.BillingDetails;
import org.openqa.selenium.WebDriver;
import rest.RestAssuredClient;

public class DriverContext {
    public WebDriver driver;
    public RestAssuredClient restAssuredClient;
    public BillingDetails billingDetails;
}
