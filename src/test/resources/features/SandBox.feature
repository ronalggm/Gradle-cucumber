
Feature: Test different actions on a sandbox page.

  Scenario: As a Test Junior, I try out different actions on a sanbox page.
    Given I navigate to the sandbox page
    And select a value from the dropdown

    Scenario: As a Test junior i want to retrive the  value of an static table.
      Given I navigate to the table
     Then I can return the value i wanted
