Feature: Employee Create service
  Background:
    * url baseUrl
    * def employeeCreateRelativeUrl = '/employees'



  Scenario: Create an employee
    Given path employeeCreateRelativeUrl
    And request {name: 'Kevin de Bruyne', role: 'MC CAM' }
    And header Accept = 'application/json'
    When method POST
    Then status 200
    And match response == {id: '9', name: 'Kevin de Bruyne', role: 'MC CAM'}

  Scenario: Get employee just created
    Given path employeeCreateRelativeUrl + '/4'
    When method GET
    Then status 200
    And match response == {id: '9', name: 'Kevin de Bruyne', role: 'MC CAM'}