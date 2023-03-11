package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver initializeDriver(String browser) {
        WebDriver driver;
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("start-maximized");
                options.addArguments("disable-infobars");
                options.addArguments("--disable-extensions");
                options.addArguments("--no-proxy-server");

                driver = new ChromeDriver(options);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            default -> throw new IllegalStateException("INVALID BROWSER: " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
}