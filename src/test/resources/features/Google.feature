Feature: Test Google search funtionality

Scenario: As a user i enter a search criteria in Google
    Given I am on the Google search page
    When I enter a search criteria
    And click on the search button
    Then the results match the criteria