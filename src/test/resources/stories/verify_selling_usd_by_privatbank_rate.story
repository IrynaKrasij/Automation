Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: VSUBAR-1 Verify selling USD by privatbank rate
Given User opens currency converter page
When User clicks on sell option link
And User selects <currencyName> currency from dropdown list
And User puts <currencyAmount> value of currency amount in sum field
And User selects <rateValue> rate value from dropdown list
Then User checks results for the list of currency <currencyList>

Examples:
|currencyName|currencyAmount|rateValue|currencyList|
|USD|300.00|ПриватБанк|UAH,EUR,RUB|
|USD|300.00|ПриватБанк|UAH,EUR,RUB|
