Feature: Testing of Login Page
Background:
  Given Set up driver

  Scenario Outline: Test of login page

    When open Andersen login page
    When Set email "<text1>"
    And Set password "<text2>"
    And Click login button
    Then Success alert message
    Examples:
      | text1 |                       | text2 |
      | S.Iaffwnfeffdsorv@gmail.com | | string123 |

  @selenium
  Scenario Outline: login with incorrect password

    When open Andersen login page
    When Set email "<text1>"
    And Set wrong password "<text3>"
    And Click login button
    Then Get error password alert
    Examples:
      | text1 |                       | text3 |
      | S.Iaffwnfeffdsorv@gmail.com | | string123fd |

  Scenario Outline: login with empty mail

    When open Andersen login page
    When Set email "<text1>"
    And Set wrong password "<text3>"
    And Click login button
    Then Get error empty mail alert
    Examples:
      | text1 |                       | text3 |
      |  |                            | string123 |
