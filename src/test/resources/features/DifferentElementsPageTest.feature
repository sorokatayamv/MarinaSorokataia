Feature: Different elements page test

  Scenario: Different elements page log
    Given I open JDI GitHub site
    And I login as user Roman Iovlev
    When I click on 'Service' button in Header
    And I click on 'Different Element page' button in Service dropdown
    And I select checkboxes Water and Wind
    And I select radio Selen
    And I select Yellow in dropdown
    Then I check if there are an individual log row and value is corresponded to the status of Water checkbox
    And I check if there are an individual log row and value is corresponded to the status of Wind checkbox
    And I check if there are an individual log row and value is corresponded to the status of Selen radio
    And I check if there are an individual log row and value is corresponded to the status of Yellow color



