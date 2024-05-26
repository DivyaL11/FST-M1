@activity5
  Feature: Data driven test with Example

    Scenario Outline: Testing with Data from Scenario
      Given the user is on the login page
      When the user enters "<Username>" and "<Password>"
      And clicks the submit button
      Then get the confirmation text to verify message as "Invalid Credentials"

