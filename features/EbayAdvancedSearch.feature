Feature: Ebay Advanced Search Page

  @p2
  Scenario: Ebay Logo on Advanced Search Page
    Given I am Ebay Advanced Search Page
    When I click on Ebay Logo
    Then I am navigated to Ebay Home Page

  @p6
  Scenario: Advanced search an item
    Given I am Ebay Advanced Search Page
    When I advanced search an item
      | keyword   | exclude     | min | max |
      | iPhone 11 | refurbished | 300 | 900 |
    Then I validate at least 1000 search items present