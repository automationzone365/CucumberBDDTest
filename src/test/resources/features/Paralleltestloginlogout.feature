
Feature: Test parallel

  Scenario: Parallel test
    Given I'm a user on the Demo Web shop home page
    And I click on logout to signout of application

  Scenario: Verify user API
    Given I'm a admin to verify a user
