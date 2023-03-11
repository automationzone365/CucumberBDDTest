package pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    private static LoginPage loginPage;
    private static ShoppingCartPage shoppingCartPage;

    private static CheckOutPage checkOutPage;
    private static LogoutPage logoutPage;

    public static LoginPage getLoginPage(WebDriver driver) {
        return loginPage == null ? new LoginPage(driver) : loginPage;
    }

    public static ShoppingCartPage getShoppingCartPage(WebDriver driver) {
        return shoppingCartPage == null ? new ShoppingCartPage(driver) : shoppingCartPage;
    }

    public static CheckOutPage getCheckoutPage(WebDriver driver) {
        return checkOutPage == null ? new CheckOutPage(driver) : checkOutPage;
    }

    public static LogoutPage getLogoutPage(WebDriver driver) {
        return logoutPage == null ? new LogoutPage(driver) : logoutPage;
    }
}
