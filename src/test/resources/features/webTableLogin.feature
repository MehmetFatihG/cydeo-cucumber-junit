Feature: User should be able to login using correct credentials


  Scenario: Positive login scenario
    Given  User is on the login page of Web table app
    When User enters username "Test"
    And User enters password "Tester"
    And User click login button
    Then User should see url contains orders


  Scenario: Positive login scenario
    Given  User is on the login page of Web table app
    When User enters username "Test" password "Tester" and logins
    Then User should see url contains orders