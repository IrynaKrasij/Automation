Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: VSUBAR-3 Verify visibility of controls on the page
Given User opens currency converter page
Then User verifies visibility <isVisible> of 'AVERAGECURRENCIESRATEINBANK, CASHMARKET, GRAPHOFFLUCTUATIONSOFMIDDLERATE' controls on the page

Examples:
|isVisible|
|false    |
