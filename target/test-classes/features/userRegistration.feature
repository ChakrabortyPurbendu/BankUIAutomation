Feature: Guru99 User Registration

  Scenario: Register new customer successfully
    Given user is logged in to Guru99 bank
    When user enters valid customer details
    Then customer should be registered successfully
