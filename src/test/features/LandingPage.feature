@Test
Feature: Landing Page

  Scenario: Test landing Page
    Given the user is on Landing page
    And the user navigates to pci page
    When the user clicks on System Status
    Then the user verifies the System Status as Operational for component Live System
