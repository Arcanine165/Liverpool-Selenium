Feature: Register service
  In this tests we want to make sure the different functionalities of the register service
  Background:
    Given  User is in Liverpool
    Given  user clicks on login
    And user clicks on create account button


  Scenario: TC_LP_RegisterUserAccount_001
    Then user is on register page


  Scenario: TC_LP_RegisterUserAccount_003
    Then user is on register page
    And user enters email as "victor.prueba@gmail.com"
    And user enters password as "Prueba1" without correct length


  Scenario: TC_LP_RegisterUserAccount_004
    Then user is on register page
    And user enters email as "victor.prueba@gmail.com"
    And user enters password as "PRUEBA1" without lowercased letters

