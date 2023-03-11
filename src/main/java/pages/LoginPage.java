package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(css = "a.ico-login")
    private WebElement loginLink;
    @FindBy(css = "input#Email")
    private WebElement emailTxt;
    @FindBy(css = "input#Password")
    private WebElement passwd;
    @FindBy(css = "input.login-button")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(loginLink));
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
        wait.until(ExpectedConditions.visibilityOf(emailTxt)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(passwd)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }
}
