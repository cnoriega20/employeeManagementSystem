Feature: Get Tests on Employees Get


Scenario: Get Employees
Given url 'http://localhost:8080/employees'
When method GET
Then status 200