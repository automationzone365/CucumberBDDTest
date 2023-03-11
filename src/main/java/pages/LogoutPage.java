package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogoutPage extends BasePage {
    @FindBy(css = ".ico-logout")
    private WebElement logoutLnk;

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void logOut() {
        wait.until(ExpectedConditions.visibilityOf(logoutLnk)).click();
    }
}
