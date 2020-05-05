Feature: POST case
  Scenario Outline: POST case test case
    Given setup base URI of API
    When create request body with name "<name>" and job "<job>"
    Then assert response with status code 201
Examples:
    |name|job|
    |abc |def|
    |cdf |asff|
