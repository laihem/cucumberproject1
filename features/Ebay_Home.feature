Feature: Ebay Home Page Scenarios

  @p1
  Scenario: Advanced Search Link
    Given I am on Ebay Home Page
    When I click on Advanced link
    Then I navigate to Advanced Search page

  @p3
  Scenario: Seach items count
    Given I am on Ebay Home Page
    When I serach for iPhone 11
    Then I validate atleast 1000 search items present