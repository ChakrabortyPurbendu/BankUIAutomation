Feature: New Customer Registration

  Scenario: Register a new customer successfully
    Given user is logged in and on new customer page
    When user enters customer details
    Then customer should be registered successfully
