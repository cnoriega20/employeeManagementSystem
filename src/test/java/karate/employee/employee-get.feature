Feature: Get Tests on Employees Get


Scenario: Testing valid GET endpoint
Given url 'http://localhost:8080/employees'
When method GET
Then status 200