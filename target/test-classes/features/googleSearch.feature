Feature: Google search functionality
  Agile story: As a user, when I am on the Google search page
  I should be able to search whatever I want and I see relevant information

  Scenario: Search page title verification
    When user is on Google search page
    Then user should see title is Google

    @wip
  Scenario: Search functionality result title verification
    Given user is on Google search page
    When user types apple and clicks enter
    Then user should see Apple in the google title


  Scenario: Search functionality result title verification
    Given user is on Google search page
    When user types "tesla" and clicks enter
    Then user should see "tesla" in the google title

