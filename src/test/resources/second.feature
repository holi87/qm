# Created by GH at 19.01.2021
Feature: Quality Minds Recrutation
  Second testcase done with Gherkin

  Scenario: Second Test Case
    Given qualtiyminds.de home page
    When Hover on Portfolio at the top of navigation
    Then Verify if submenu is displayed

    When Click on Web, Automation & Mobile Testing sub option
    Then Web, Automation & Mobile Testing page is displayed
    Then Portfolio item on the top bar menu is highlighted

    When Click on Mobile tab in "Web-Automatiserung - Mobile" section
    Then Mobile section content is displayed
    Then Mobile is underlined in grey
    Then "Flyer find the bug session" button is displayed on the right

    Then The download link for the flyer should be equal to set url
    Then File is available via download link