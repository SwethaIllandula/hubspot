Feature: To check or To fill details on CalendarPage

  Scenario Outline:
    Given User is on CalendarPage
    When User fills the form in the "<Title>" and "<Company>" and "<Deal>" and "<Task>" and "<Case>"
    Then  User also fills the form with "<Tags>" and  "<location>" and "<Notes>" and  "<Minutes>"
    Then User should be able to save the details



    Examples:
      |Title | Company | Deal| Task | Case | Tags | location | Notes | Minutes|

      | Mrs | MavenITTechnologies | Jobdeals | QAtask | Test | AutomationTags | London | This is just to automate | 45Minutes|