Feature: Login Page

  Scenario: Login Page Open Successfully
    Given Browser Should be Open
    And URL is Launched
    When Verified Login Page Title
    Then Browser Closed

  Scenario: Login With Valid Credentials
    Given Browser Should be Open
    And URL is Launched
    Given Enter Valid Username and Password
    Given Click on LoginButton
    When Verified Login Page Title
    Then Take Screenshots
    Then Click On LogoOutButton
    Then Browser Closed