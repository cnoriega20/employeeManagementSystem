Feature: Employee Create service
  Background:
    * url baseUrl
    * def employeeCreateRelativeUrl = '/employees'



  Scenario: Create an employee
    Given path employeeCreateRelativeUrl
    And request {name: 'Alisson Becker', role: 'Liv GK' }
    And header Accept = 'application/json'
    When method POST
    Then status 200
    And match response == {id: 12, name: 'Alisson Becker', role: 'Liv GK'}

  Scenario: Get employee just created
    Given path employeeCreateRelativeUrl + '/12'
    When method GET
    Then status 200
    And match response == {id: 12, name: 'Alisson Becker', role: 'Liv GK'}