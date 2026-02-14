Feature: Bank Demo App

@smoke
Scenario: Login to Bank Demo app
  Given I open the Bank Demo app
  When I login with "practice" and "practice"

@regression
Scenario: Make a payment after login
  Given I open the Bank Demo app
  When I login with "practice" and "practice"
  And I make a payment with phone "1234567890", name "Hari", amount "500", country "India"
  Then transaction should be successful
