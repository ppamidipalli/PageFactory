Feature: PSP Login

  Scenario: User logs in with invalid credentials
    Given user navigates to psp login page
    When user logs in with invalid credentials
    Then login is unsuccessful
