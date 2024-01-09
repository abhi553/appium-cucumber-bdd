@test
Feature: Login scenarios

  Scenario: Verify user open apps
    Given that the user launches the BASRON application on the mobile
    When the user clicks on Login button
    Then the sign in screen displayed

  Scenario Outline: Login with valid user name and password
    Given that the user launches the BASRON application on the mobile
    When the user clicks on Login button
   And user enters username as "<username>"
    And user enters password as "<password>"
    Then user clicks on Login button after entering data
    Examples:
      | username | password |
      | abc@gmail.com | test1234 |

#  Scenario Outline: Verification of Admin Dashboard
#    Given that user is on the Dashboard
#    When the user verify the list
#    Then user sees requests
#    And user seees the option to historical requests
##    And user sees the option to trigger the reconciliation
#    Examples:
#      | username | password |
#      | abc@gmail.com | test1234 |






