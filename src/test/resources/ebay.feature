Feature: Home Page
  Scenario Outline: User on  home page
    Given user on home page "<url>"
  Examples:
  |url|
  |https://www.ebay.com|
  Scenario Outline: Search for products
    Given user on home page "<url>"
    When user enter search term "<searchterm>"and click on search button
    Then user should see search results
  Examples:
    |url|searchterm|
    |https://www.ebay.com|iphone 6s|

  Scenario Outline: User can select products from results list
    Given user on home page "<url>"
    When user enter search term "<searchterm>"and click on search button
    Then user should see search results
    And user can select product from results
  Examples:
    |url|searchterm|
    |https://www.ebay.com|iphone 6s|
    |https://www.ebay.com|iphone 7s|
