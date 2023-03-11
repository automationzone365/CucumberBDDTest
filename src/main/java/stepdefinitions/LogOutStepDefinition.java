package stepdefinitions;

import context.DriverContext;
import io.cucumber.java.en.And;
import pages.CheckOutPage;
import pages.LogoutPage;
import pages.PageFactoryManager;

public class LogOutStepDefinition {

    private final LogoutPage logoutPage;

    public LogOutStepDefinition(DriverContext context) {

        logoutPage = PageFactoryManager.getLogoutPage(context.driver);
    }

    @And("I click on logout to signout of application")
    public void logOut() {
        logoutPage.logOut();
    }
}
