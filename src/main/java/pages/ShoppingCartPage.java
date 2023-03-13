package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class ShoppingCartPage extends BasePage {
    @FindBy(css = "span.cart-qty")
    private WebElement cartQuantitySpan;
    @FindBy(css = "li#topcartlink a")
    private WebElement shoppingCartLink;
    @FindBy(css = "[name=removefromcart]")
    private List<WebElement> removeCartitemsChkbxlst;
    @FindBy(css = "input[name=updatecart]")
    private WebElement updateShoppingCartbtn;
    @FindBy(css = "order-summary-content")
    private WebElement shoppingCartmsgdiv;
    @FindBy(css = "ul.top-menu > li:nth-child(2) > a")
    private WebElement computersLnk;
    @FindBy(css = "ul.top-menu > li:nth-child(2) > ul > li:nth-child(1) > a")
    private WebElement desktopsLnk;
    @FindBy(xpath = "//*[@id=\"addtocart_72_EnteredQuantity\"]")
    private WebElement prdQtyInputcls;

    @FindBy(css = "input.add-to-cart-button")
    private WebElement addToCartbtn;
    @FindBy(css = "#bar-notification > p")
    private WebElement notificationMsg;
    @FindBy(css = "#bar-notification > span")
    private WebElement notifyClsSpan;
    @FindBy(css = "table tr > td.qty.nobr > input")
    private WebElement itemQuanityInput;

    @FindBy(css = "table td.unit-price.nobr > span.product-unit-price")
    private WebElement prodUnitPriceSpan;
    @FindBy(css = "tr:nth-child(1) > td.cart-total-right > span > span")
    private WebElement subTotalCartPriceSpan;
    @FindBy(css = "input#termsofservice")
    private WebElement termsOfServiceChk;
    @FindBy(css = "button#checkout")
    private WebElement chkOutBtn;


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartPage clearCart() {
        /* Clearing the cart by selecting all the available items checkboxes */
        List<WebElement> cartItems = wait.until(ExpectedConditions.visibilityOfAllElements(removeCartitemsChkbxlst));
        cartItems.stream().forEach(chk -> {
            wait.until(ExpectedConditions.elementToBeClickable(chk)).click();
        });
        wait.until(ExpectedConditions.elementToBeClickable(updateShoppingCartbtn)).click();
        return this;
    }

    public String getShoppingemptymsg() {
        return wait.until(ExpectedConditions.visibilityOf(shoppingCartmsgdiv)).getText();
    }

    public String getCartQTY() {
        return wait.until(ExpectedConditions.visibilityOf(cartQuantitySpan)).getText();
    }

    public void navToShoppingCart() {
        wait.until(ExpectedConditions.visibilityOf(shoppingCartLink));
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink)).click();
    }

    public void navToProductcategory() {
        wait.until(ExpectedConditions.visibilityOf(computersLnk));
        Actions act = new Actions(driver);
        act.moveToElement(computersLnk);
        act.moveToElement(desktopsLnk);
        act.click().build().perform();
    }

    public void selProduct(String productName) {
        String raw = "img[alt='Picture of " + productName + "']";
        byte[] bytes = raw.getBytes(StandardCharsets.UTF_8);
        String utf8Encoded = new String(bytes, StandardCharsets.UTF_8);
        By prdImgBtn = By.cssSelector(utf8Encoded);
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(prdImgBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
    }

    public void setQuantity(String qty) {
        wait.until(ExpectedConditions.visibilityOf(prdQtyInputcls));
        Actions act = new Actions(driver);
        act.moveToElement(prdQtyInputcls);
        prdQtyInputcls.click();
        prdQtyInputcls.clear();
        wait.until(ExpectedConditions.elementToBeClickable(prdQtyInputcls));
        prdQtyInputcls.click();
        act.sendKeys(qty).build().perform();
    }

    public void addToCart() {
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(addToCartbtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
        ele.click();
    }

    public String getNotificationmsg() {
        return wait.until(ExpectedConditions.visibilityOf(notificationMsg)).getText();
    }

    public ShoppingCartPage clsNotification() {
        wait.until(ExpectedConditions.elementToBeClickable(notifyClsSpan)).click();
        return this;
    }

    public double getProductUnitPrice() {
        return Double.parseDouble(wait.until(ExpectedConditions.visibilityOf(prodUnitPriceSpan)).getText());
    }

    public double getProductQuantity() {
        return Double.parseDouble(wait.until(ExpectedConditions.visibilityOf(itemQuanityInput)).getAttribute("value"));
    }

    public double getProductSubTotal() {
        return Double.parseDouble(wait.until(ExpectedConditions.visibilityOf(subTotalCartPriceSpan)).getText());
    }

    public ShoppingCartPage agreeWithTerms() {
        wait.until(ExpectedConditions.elementToBeClickable(termsOfServiceChk)).click();
        return this;
    }

    public void checkout() {
        wait.until(ExpectedConditions.elementToBeClickable(chkOutBtn)).click();
    }
}
