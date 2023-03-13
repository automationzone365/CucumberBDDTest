package pages;

import domainobjects.BillingDetails;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage {
    @FindBy(id = "billing-address-select")
    private WebElement billingAddressSel;
    @FindBy(id = "BillingNewAddress_FirstName")
    private WebElement billingFirstnameId;
    @FindBy(id = "BillingNewAddress_LastName")
    private WebElement billingLastNameId;
    @FindBy(id = "BillingNewAddress_Email")
    private WebElement billingEmailId;
    @FindBy(id = "BillingNewAddress_Company")
    private WebElement billingCompanyId;
    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement billingCountrySel;
    @FindBy(id = "BillingNewAddress_City")
    private WebElement billingCityId;
    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement billingAddressOneId;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement billingZipId;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement billingPhoneId;
    @FindBy(css = "#billing-buttons-container > input")
    private WebElement continueBtn;

    @FindBy(id = "shipping-address-select")
    private WebElement shippingAddressSel;
    @FindBy(css = "#shipping-buttons-container > input")
    private WebElement shippingAddContinueBtn;

    @FindBy(css = "#shippingoption_1")
    private WebElement shippingMethodRbtn;
    @FindBy(css = "#shipping-method-buttons-container > input")
    private WebElement shippingMethodContBtn;

    @FindBy(css = "#paymentmethod_0")
    private WebElement payMethodCODRbtn;
    @FindBy(css = "#payment-method-buttons-container > input")
    private WebElement payMethodContBtn;
    @FindBy(css = "#payment-info-buttons-container > input")
    private WebElement payInfoContBtn;

    @FindBy(css = "#confirm-order-buttons-container > input")
    private WebElement orderConfirmBtn;
    @FindBy(css = "div > div.title > strong")
    private WebElement orderConfirmTxt;
    @FindBy(css = "div > ul[class='details']> li:nth-child(1)")
    private WebElement orderNoTxt;
    @FindBy(css = "div > div.buttons > input")
    private WebElement orderContBtn;

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }


    public CheckOutPage enterBillingFirstName(String billingFirstName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingFirstnameId));
        e.clear();
        e.sendKeys(billingFirstName);
        return this;
    }

    public CheckOutPage enterBillingLastName(String billingLastName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingLastNameId));
        e.clear();
        e.sendKeys(billingLastName);
        return this;
    }

    public CheckOutPage enterEmailId(String billingEmailAdd) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingEmailId));
        e.clear();
        e.sendKeys(billingEmailAdd);
        return this;
    }

    public CheckOutPage enterCompanyId(String billingCompanyname) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingCompanyId));
        e.clear();
        e.sendKeys(billingCompanyname);
        return this;
    }


    public CheckOutPage selectCountry(String countryName) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingCountrySel)));
        select.selectByVisibleText(countryName);
        return this;
    }

    public String getCity() {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingCountrySel)));
        return select.getFirstSelectedOption().getText();
    }

    public CheckOutPage selectBillAddress(String billingAddress) {

        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingAddressSel)));
        select.selectByVisibleText(billingAddress);
        return this;
    }

    public CheckOutPage enterCityId(String billingCity) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingCityId));
        e.clear();
        e.sendKeys(billingCity);
        return this;
    }

    public CheckOutPage enterBillingAddress1(String billingAddress1) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingAddressOneId));
        e.clear();
        e.sendKeys(billingAddress1);
        return this;
    }

    public CheckOutPage enterBillingZipCode(String billingZipCode) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingZipId));
        e.clear();
        e.sendKeys(billingZipCode);
        return this;
    }

    public CheckOutPage enterBillingPhoneId(String billingPhone) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingPhoneId));
        e.clear();
        e.sendKeys(billingPhone);
        return this;
    }

    public CheckOutPage setBillingDetails(BillingDetails billingDetails) {
        return enterBillingFirstName(billingDetails.getBillingFirstName()).
                enterBillingLastName(billingDetails.getBillingLastName()).
                enterEmailId(billingDetails.getBillingEmail()).
                enterCompanyId(billingDetails.getBillingCity()).
                selectCountry(billingDetails.getBillingCountry()).
                enterCityId(billingDetails.getBillingCity()).
                enterBillingAddress1(billingDetails.getBillingAddressOne()).
                enterBillingZipCode(billingDetails.getBillingZip()).
                enterBillingPhoneId(billingDetails.getBillingPhone());
    }

    public void navToShippingAddresssel() {
        wait.until(ExpectedConditions.visibilityOf(continueBtn));
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    public CheckOutPage selectShippingAddress(String shippingAddress) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(shippingAddressSel)));
        select.selectByVisibleText(shippingAddress);
        return this;
    }

    public void navToShippingMethod() {
        wait.until(ExpectedConditions.visibilityOf(shippingAddContinueBtn));
        wait.until(ExpectedConditions.elementToBeClickable(shippingAddContinueBtn)).click();
    }

    public void shippingMethodSel() {
        //wait.until(ExpectedConditions.elementToBeSelected(shippingMethodRbtn));
        wait.until(ExpectedConditions.visibilityOf(shippingMethodRbtn)).click();
    }

    public void navToPaymentMethod() {
        wait.until(ExpectedConditions.visibilityOf(shippingMethodContBtn));
        wait.until(ExpectedConditions.elementToBeClickable(shippingMethodContBtn)).click();
    }

    public void payMethodSel() {
        wait.until(ExpectedConditions.elementToBeSelected(payMethodCODRbtn));
        wait.until(ExpectedConditions.visibilityOf(payMethodCODRbtn)).click();
    }

    public void navToPaymentInfo() {
        wait.until(ExpectedConditions.visibilityOf(payMethodContBtn));
        wait.until(ExpectedConditions.elementToBeClickable(payMethodContBtn)).click();
    }

    public void navToConfirmOrder() {
        wait.until(ExpectedConditions.visibilityOf(payInfoContBtn));
        wait.until(ExpectedConditions.elementToBeClickable(payInfoContBtn)).click();
    }

    public CheckOutPage placeOrder() {
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(orderConfirmBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
        ele.click();
        return this;
    }

    public String getOrderSuccessMsg() {
        return wait.until(ExpectedConditions.visibilityOf(orderConfirmTxt)).getText();
    }

    public int getOrderNumber() {
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(orderNoTxt))
                .getText().split(":")[1].trim());
    }

    public void navToHome() {
        wait.until(ExpectedConditions.visibilityOf(orderContBtn));
        wait.until(ExpectedConditions.elementToBeClickable(orderContBtn)).click();
    }


}
