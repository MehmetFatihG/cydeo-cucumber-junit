Feature: User should be able to login using correct credentials

  Background: user is on the login page
    Given  User is on the login page of Web table app

  Scenario: Positive login scenario
    When User enters username "Test"
    And User enters password "Tester"
    And User click login button
    Then User should see url contains orders


  Scenario: Positive login scenario
    When User enters username "Test" password "Tester" and logins
    Then User should see url contains orders


  Scenario: User should be able to see all 12 months in months dropdown
    When User enters below credentials
      | username | Test   |
      | password | Tester |
    Then User should see url contains orders
