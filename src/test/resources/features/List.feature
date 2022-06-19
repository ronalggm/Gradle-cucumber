Feature: validate a List With Selenium

 @List
  Scenario Outline: : As a Test Enginner, I want to validate that a text is present inside the list.

    Given I navigate to the list page
    When I search <state> in the list
    Then I can find <city> city in the list

    Examples:
      | state      | city                |
      | Washington | Seattle, Washington |
      | Chicago    | Chicago, Illinois   |