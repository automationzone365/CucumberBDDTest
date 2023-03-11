package stepdefinitions;

import context.DriverContext;
import domainobjects.BillingDetails;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CheckOutPage;
import pages.PageFactoryManager;

public class CheckOutStepDefinition {
    private final DriverContext context;
    private final CheckOutPage checkOutPage;

    public CheckOutStepDefinition(DriverContext context) {
        this.context = context;
        checkOutPage = PageFactoryManager.getCheckoutPage(context.driver);
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        context.billingDetails = billingDetails;
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
        /* Creating a new Address here */
        checkOutPage.selectBillAddress("New Address");
        /* Here we are filling data using the custom datatype saved */
        checkOutPage.setBillingDetails(context.billingDetails);
        checkOutPage.navToShippingAddresssel();
    }

    @When("I provide shipping details")
    public void iProvideShippingDetails() {
       /*
         Here we are dynamically forming the shipping address selected
         in the billing address
        */
        checkOutPage.selectShippingAddress(context.billingDetails.getBillingFirstName() + " " + context.billingDetails.getBillingLastName()
                + ", " + context.billingDetails.getBillingAddressOne() + ", " + context.billingDetails.getBillingCity() + " "
                + context.billingDetails.getBillingZip() + ", " + context.billingDetails.getBillingCountry());
        checkOutPage.navToShippingMethod();
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        /*
        Here are selecting the payment method and confirming the order
        */
        checkOutPage.shippingMethodSel();
        checkOutPage.navToPaymentMethod();
        checkOutPage.payMethodSel();
        checkOutPage.navToPaymentInfo();
        checkOutPage.navToConfirmOrder();
        checkOutPage.placeOrder();

    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        /* Asserting the order success message and printing the Order number for further reference */
        Assert.assertEquals("Your order has been successfully processed!", checkOutPage.getOrderSuccessMsg());
        System.out.println("Order number generated for this entry :" + checkOutPage.getOrderNumber());
        checkOutPage.navToHome();
    }
}
