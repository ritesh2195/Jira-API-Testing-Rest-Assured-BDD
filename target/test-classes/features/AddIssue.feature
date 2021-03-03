Feature: Adding new issue

  Scenario: adding issue in Jira

    Given user authenticate himself
    When when user hit "POST" request
    Then user should get 201 response code
    And response body should contains "id" and "key"