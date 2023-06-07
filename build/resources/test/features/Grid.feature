Feature: Test Retrieving data from a cell in a table

  Scenario: As a user i retrieve a value of a cell in a table
    Given I navigate to the static table
    Then I can return the value i wanted

  @Test
  Scenario: As a Test Engineer, I want to validate the static table is displayed
    Given I navigate to the static table
    Then I can validate the table is displayed

  @Test
  Scenario: As a Test Engineer, I want to validate that a text is present inside the list
    Given I navigate to the list page
    When I search the list
    Then I can find the text in the list