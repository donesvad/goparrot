Feature: Search field

  Background:
    Given user is on Location page

  @SearchBox @HelpMessage
  Scenario Outline: User should be asked for being more specific
    When user is looking for "<Search input>" location using button
    Then user should be asked for being more specific
    Examples:
      | Search input |
      | New York     |
      | London       |

  @SearchBox @Clear
  Scenario: Verify ability to clear Search input field
    When user is looking for "Washington" location using enter
    And user clear input Search field
    Then search input field should be empty

  @SearchBox @AutoComplete
  Scenario: Verify ability to select from auto complete drop down
    When user fills in "New" value into Search Field
    And user selects "New YorkNY, USA" item from search drop down
    Then search input field should contain value "New York, NY, USA"
