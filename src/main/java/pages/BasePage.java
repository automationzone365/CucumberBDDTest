package pages;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    private static final String BDDScript_JS;
     JavascriptExecutor js = null;
     
     static {
         BDDScript_JS="if(typeof getSelector=='undefined'){getSelector=function(e){const i1=e.charAt(0);const i2=e.charAt(1);if(i1=='i')return 'document.getElementById(\\''+e.substring(3)+'\\')';if(i2=='l'&&i1=='c')return 'document.getElementsByClassName(\\''+e.substring(6)+'\\')';if(i1=='t')return 'document.getElementsByTagName(\\''+e.substring(4)+'\\')';if(i2=='s'&&i1=='c')return 'document.querySelectorAll(\\''+e.substring(4)+'\\')';return e;};}if(typeof BDD_Filter=='undefined'){BDD_Filter=function(e){var t = [];for(var i=0;i<e.length;++i){if(typeof e[i]!='undefined'&&e[i]!=undefined&&e[i].offsetWidth>1){e[i].find=function(f){return BDD_Filter(eval(getSelector(f).replace('document', 'this')));};t.push(e[i]);}}return t;};}if(typeof BDD_SmartUI=='undefined'){BDD_SmartUI = function(e){return BDD_Filter(eval(getSelector(e)));};}if(typeof BDD_GenId=='undefined'){BDD_GenId=function(e){var id=e.id;var key='genkey_';var d = new Date();if(id=='undefined'||id==\"\"||id==null){var t=d.getTime();id=e.setAttribute('id',key+t);}return e.id;}}";
     }
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void load(String endPoint) {
        driver.get(endPoint);
    }

    public String executeScript(String script){
        String returnValue = null;
        try {
            js = (JavascriptExecutor) driver;
            script=BDDScript_JS.concat(script);
            System.out.println(script);
             returnValue=(String) js.executeScript(script);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return returnValue;

    }
    public String generateIDLocator(String locator){
        return this.executeScript("return BDD_GenId("+locator+")");
    }
}
