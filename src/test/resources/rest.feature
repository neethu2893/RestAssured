Feature:Rest api GET
  Scenario Outline: GET request for REST
    Given set up API environment
    When search page "<page>"
    Then result displayed
    Examples:
    |page|
    |2    |
    |1    |

