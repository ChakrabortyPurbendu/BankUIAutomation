Feature: Guru99 Login

  Scenario: Valid login to Guru99 Bank
    Given user opens the Guru99 login page
    When user enters valid username and password
    Then user should be logged in successfully
