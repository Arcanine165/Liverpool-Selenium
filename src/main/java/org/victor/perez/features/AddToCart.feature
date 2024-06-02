Feature: Add to Cart
  Background:
    Given User is in home
    Given User clicks on search bar

  @AddToCart
  Scenario Outline: Test addToCart with different products
    And Types product as "<product>"
    Then User clicks enter
    Then User selects the third item
    Then User is in ProductDetail page
    And User adds the product to the cart
    And Alert of success appear
    Then User goes to the cart
    And validate if its there
    Examples:
      | product    |
      | Television |
      | licuadora  |

  @AddToCart
  Scenario Outline: Test error when user tries to add to cart and doesn't select size
    And Types product as "<product>"
    Then User clicks enter
    Then User selects the third item
    Then User is in ProductDetail page
    And User adds the product to the cart
    Then Error appears if user doesn't select size
    Examples:
      | product |
      | tennis  |

  @SearchFailed
  Scenario: Test error page when products are not found
    And Types product as "asdasdasd"
    Then User clicks enter
    Then The page displays a landing page error
