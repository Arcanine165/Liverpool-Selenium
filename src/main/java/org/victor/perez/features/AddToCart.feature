Feature: Add to Cart
  Background:
    Given User is in home
    Given User clicks on search bar


    @Search
    Scenario Outline: Test search with different products
      And Types product as "<product>"
      Then User clicks enter
      Then User selects the third item
      Then User is in ProductDetail page
      And User adds the product to the cart
      And Alert of success appear
      Then User goes to the cart
      And validate if its there
      Examples:
      |product|
      |Television|
      |licuadora    |

  @Search
  Scenario Outline: Test error when user dont select size
    And Types product as "<product>"
    Then User clicks enter
    Then User selects the third item
    Then User is in ProductDetail page
    And User adds the product to the cart
    Then Error appears if user don't select size
    Examples:
      |product|
      |tennis |