Feature: Ebay Home Page Scenarios

  @p1
  Scenario: Advanced Search Link
    Given I am on Ebay Home Page
    When I click on Advanced link
    Then I navigate to Advanced Search page

  @p3
  Scenario: Search items count
    Given I am on Ebay Home Page
    When I search for 'iPhone 11'
    Then I validate at least 1000 search items present

  @p4
  Scenario: Search items count2
    Given I am on Ebay Home Page
    When I search for 'Toy Cars'
    Then I validate at least 100 search items present

  @p5
  Scenario: Search an item in category
    Given I am on Ebay Home Page
    When I serach for 'soap' in 'BaBy' category
    Then I validate at least 1000 search items present

  @p7
  Scenario Outline: Home page links
    Given I am on Ebay Home Page
    When I click on '<link>'
    Then I validate that page navigates to '<url>' and title contains '<title>'

    Examples:
      | link    | url                                                            | title       |
      | Motors  | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334 | eBay Motors |
      | Fashion | https://www.ebay.com/b/Fashion/bn_7000259856                   | Fashion     |
      | Toys    | https://www.ebay.com/b/Toys-Hobbies/220/bn_1865497             | Toys        |
