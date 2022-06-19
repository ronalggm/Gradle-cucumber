Feature: Test Google search functionality

  Scenario: As a user i enter a search criteria in goolge

  Given I am on the Google search app
  When I enter a search criteria
  And click on the search button
  Then the result match the criteria
