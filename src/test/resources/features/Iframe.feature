Feature: Test a webPage with Iframe of wikipedia

  Scenario: As test junior i want to use actions on a Iframe
    Given I navigate to the webPage
    When I entry to the Iframe wikipedia
    And I enter a search chriteria
    And click on the search button of wikipedia
    Then result match the chriteria
