Feature: login user in gmail

  Scenario Outline: successful login with valid credentials
    Given user is on gmail login page
    When user enters login <username> and press submit
    And enters password <password> and press submit
    Then user successful logged in
    Then quit from driver

    Examples:
      | username              | password  |
      | kononcewa63@gmail.com | k02101963 |
      | vovasleb@gmail.com    | Vv937891525 |