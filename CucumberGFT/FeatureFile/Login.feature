Feature: Login Functionality
@data-driven
Scenario: Login with valid credentials
Given Navigate to Home page
When user enters username and password
Then user logged in successfully

@data-driven
Scenario: The one where user picks different product throufh search functionality 
When Larry searches below products in the search box:
|Head |
|Travel|
|laptop|
Then product should be added in the cart if available

@user-specific
Scenario Outline: Login with valid credentials
Given Navigate to Home page
When user enters username and password
Then user logged in successfully

Examples:

|userName |password|
|lalitha|Password123|
|ABC|XYZ|