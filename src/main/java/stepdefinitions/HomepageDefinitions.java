package stepdefinitions;

import context.DriverContext;
import io.cucumber.java.en.Given;
import pages.LoginPage;
import pages.PageFactoryManager;
import utils.ConfigLoader;

import java.util.Base64;

public class HomepageDefinitions {
    private final LoginPage loginPage;

    public HomepageDefinitions(DriverContext context) {
        loginPage = PageFactoryManager.getLoginPage(context.driver);
    }

    @Given("I'm a user on the Demo Web shop home page")
    public void iMOnTheDemoHomePage() {
        /* Here we are loading the application base URL and credentials */
        loginPage.load(ConfigLoader.getInstance().getBaseUrl());
        loginPage.login(ConfigLoader.getInstance().getUsername(), new String(Base64.getDecoder().decode(ConfigLoader.getInstance().getPassword().getBytes())));
    }
}
