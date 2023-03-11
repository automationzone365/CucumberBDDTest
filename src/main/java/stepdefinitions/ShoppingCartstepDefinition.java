package stepdefinitions;

import context.DriverContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PageFactoryManager;
import pages.ShoppingCartPage;


public class ShoppingCartstepDefinition {

    private final ShoppingCartPage shoppingCartPage;

    public ShoppingCartstepDefinition(DriverContext context) {
        shoppingCartPage = PageFactoryManager.getShoppingCartPage(context.driver);
    }

    @When("I add a product {string} with quantity {string} to the cart")
    public void addProduct(String product, String qty) {
        /*
         Here we are checking if the cart is empty or not
         if not we are clearing the cart
        */
        if (!shoppingCartPage.getCartQTY().equals("(0)")) {
            System.out.println("shopping cart is not empty");
            shoppingCartPage.navToShoppingCart();
            shoppingCartPage.clearCart();
        }
        System.out.println("product is " + product);
        shoppingCartPage.navToProductcategory();
        shoppingCartPage.selProduct(product);
        shoppingCartPage.setQuantity(qty);
        shoppingCartPage.addToCart();
    }

    @Then("I should see {string}")
    public void iShouldSee(String succmsg) {
        /* Asserting the success message (product has been added to your shopping cart) */
        Assert.assertEquals(shoppingCartPage.getNotificationmsg(), succmsg);

    }

    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
        shoppingCartPage.clsNotification();
        shoppingCartPage.navToShoppingCart();
        /* Calculating the product subtotal */
        double calProdVal = shoppingCartPage.getProductUnitPrice() * shoppingCartPage.getProductQuantity();
        /* Asserting the above calculated value with the expected value */
        Assert.assertEquals("Validation of actual and calculated product subtotal", calProdVal, shoppingCartPage.getProductSubTotal(), 0);
        System.out.println("value is same" + Double.compare(calProdVal, shoppingCartPage.getProductSubTotal()));
        shoppingCartPage.agreeWithTerms();
        shoppingCartPage.checkout();
    }


}
