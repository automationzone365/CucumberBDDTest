#Author: jmurali
Feature: Place an order

  Scenario Outline: Placing an order for Desktop computers
    Given I'm a user on the Demo Web shop home page
    And my billing details are
      | firstname | lastname | email                  | company | country | city  | Addressone  | zip    | Phone     |
      | demo      | user     | planittest78@gmail.com | planit  | Austria | Texas | Testaddress | 756445 | 987657448 |
    When I add a product "<Product_name>" with quantity "<Quantity>" to the cart
    Then I should see "<Success_msg>"
    And I'm on the Checkout page
    When I provide billing details
    When I provide shipping details
    And I place an order
    Then the order should be placed successfully
    And I click on logout to signout of application
    Examples:
      | Product_name                  | Quantity | Success_msg                                      |
      | Build your own cheap computer | 2        | The product has been added to your shopping cart |


