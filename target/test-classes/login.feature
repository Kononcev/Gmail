Feature: login user in gmail

  Scenario: successful login with valid credentials
    Given user is on gmail login page
    When user enters login kononcewa63@gmail.com and press submit
    And enters password k02101963 and press submit
    Then user successful logged in
    Then quit from driver