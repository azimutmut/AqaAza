Feature: Testing of Login Page Selenide
  Background:
    Given Set up driver Selenide

  Scenario Outline: Test of login page Selenide

    When open Andersen login page Selenide
    When Set email Selenide "<text1>"
    And Set password  Selenide "<text2>"
    And Click login button Selenide
    Then Success alert message Selenide
    Examples:
      | text1 |                       | text2 |
      | S.Iaffwnfeffdsorv@gmail.com | | string123 |
