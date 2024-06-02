Feature: Login Feature
  Background:
    Given User is in Liverpool HomePage

    @Login
    Scenario Outline: TC
      Then User clicks on Iniciar sesión
      Given User enters username as "<username>" and password as "<password>"
      Then user clicks on iniciar

      Examples:
      |username|password|
      |victor_perezvaldez@hotmail.com|Prueba12345$|
