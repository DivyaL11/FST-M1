@activity2
Feature: Activity to test the login feature

  @loginTest
  Scenario: Successfully login
    Given the user is on the login page
    When the user enters username and password
    And clicks the login button
    Then get the confirmation text to verify message