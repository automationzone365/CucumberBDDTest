package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver initializeDriver(String browser) {
        WebDriver driver = null;
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("autofill.profile_enabled",false);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("start-maximized");
                options.setExperimentalOption("prefs", prefs);
                 driver = new ChromeDriver(options);
//                try{
//                    WebDriverManager.chromedriver().setup();
//                    Map<String, Object> prefs = new HashMap<String, Object>();
//                    prefs.put("autofill.profile_enabled",false);
//                    ChromeOptions options = new ChromeOptions();
//                    options.addArguments("--remote-allow-origins=*");
//                    options.addArguments("start-maximized");
//                    options.setExperimentalOption("prefs", prefs);
//                    driver = new RemoteWebDriver(new URL("http://13.234.38.4:4444/wd/hub"),options);
//                }
//                catch (MalformedURLException e){
//                    e.printStackTrace();
//                }

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