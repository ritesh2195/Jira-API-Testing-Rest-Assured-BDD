Feature: Adding new issue

  Background: user authorized

    Given user authenticate himself

  @POST
  Scenario: adding issue in Jira

    When user hit "POST" request
    Then user should get 201 status code
    And response body should contains "id" and "key"

  @GET
  Scenario: Getting issue in Jira

    When user hit "GET" request with key "JA-10"
    Then user should get 200 status code
    And response body key should match with given key

