package hooks;

import context.DriverContext;
import factory.DriverFactory;


import factory.RestAssuredServiceFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import rest.RestAssuredClient;


public class BeforeAfterHook {
    private WebDriver driver;
    private RestAssuredClient restClient;
    private final DriverContext context;

    public BeforeAfterHook(DriverContext context) {
        this.context = context;
    }

    @Before
    public void before(Scenario scenario) {
        System.out.println("BEFORE: THREAD ID : " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME: " + scenario.getName());
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "firefox"));
        RestAssuredServiceFactory.registerClient();
        restClient = RestAssuredServiceFactory.getRestAssuredClient();
        context.driver = driver;
        context.restAssuredClient=restClient;
    }

    @After
    public void after(Scenario scenario) {
        System.out.println("AFTER: THREAD ID : " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME: " + scenario.getName());
        driver.quit();
    }
    @AfterStep
    public void addScreenshot(Scenario scenario){
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }
}
