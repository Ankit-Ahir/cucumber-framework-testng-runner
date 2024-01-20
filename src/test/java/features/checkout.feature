Feature: Place the order

  @PlaceOrder
  Scenario Outline: Enter promo code and place the order

    Given user is on GreenKart landing page
    When user search the product with shortname <Name> and extract the actual name of product
    And added "3" items of the selected product to the cart
    Then validate the product in checkout page and then proceed to checkout
    And verify user has ability to enter promo code and place the order

    Examples:
      | Name |
      | Tom  |