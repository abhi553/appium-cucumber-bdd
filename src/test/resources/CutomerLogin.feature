

Feature: Login scenarios

  Scenario: Verify user open BASRON Customer app
    Given that the user launches the BASRON application on the mobile
    When the user clicks on Login button
    Then the sign in screen displayed


  Scenario Outline: BASRON customer enters Login details
    Given that the user launches the BASRON application on the mobile
    When the user clicks on Login button
    And user enters username as "<username>"
    And user enters password as "<password>"
    Then user clicks on Login button after entering data
    Examples:
      | username | password |
      | abc@gmail.com | test1234 |

