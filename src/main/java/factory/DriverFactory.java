package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
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
             /*   WebDriverManager.chromedriver().setup();
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("autofill.profile_enabled",false);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("start-maximized");
                options.setExperimentalOption("prefs", prefs); */
                // driver = new ChromeDriver(options);

               try{
                   WebDriverManager.chromedriver().setup();
                    Map<String, Object> prefs = new HashMap<String, Object>();
                   prefs.put("autofill.profile_enabled",false);
                    ChromeOptions options = new ChromeOptions();
                   options.addArguments("--remote-allow-origins=*");
                    options.addArguments("start-maximized");
                    options.setExperimentalOption("prefs", prefs);
                    driver = new RemoteWebDriver(new URL("http://localhost:4444"),options);
                }
               catch (MalformedURLException e){
                   e.printStackTrace();
                }

            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }

            case "edge" ->{
                try{
                    WebDriverManager.edgedriver().setup();
                    Map<String, Object> prefs = new HashMap<String, Object>();
                    prefs.put("autofill.profile_enabled",false);
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("start-maximized");
                    options.setExperimentalOption("prefs", prefs);
                    driver = new RemoteWebDriver(new URL("http://localhost:4444"),options);
                }
                catch (MalformedURLException e){
                    e.printStackTrace();
                }
            }
            default -> throw new IllegalStateException("INVALID BROWSER: " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
}