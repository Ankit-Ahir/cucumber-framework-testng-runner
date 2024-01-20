Feature: Search

  @SearchProduct
  Scenario Outline: search product in both landing and offers page

    Given user is on GreenKart landing page
    When user search the product with shortname <Name> and extract the actual name of product
    Then user search the product with shortname <Name> in offers page
    And validate product name in offers page matches with landing page

    Examples:
      | Name |
      | Tom  |
      | Beet |