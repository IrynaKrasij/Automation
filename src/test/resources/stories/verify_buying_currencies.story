Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: VSUBAR-2 Verify buying currencies
Given User opens currency converter page
When User clicks on buy option link
And User selects <currencyName> currency from dropdown list
And User puts <currencyAmount> value of currency amount in sum field
And User selects <rateValue> rate value from dropdown list
Then User checks results for the list of currency <currencyList>

Examples:
|currencyName|currencyAmount|rateValue|currencyList|
|USD|300.00|ПриватБанк|UAH,EUR,RUB|
|USD|400.00|Средний курс|UAH,EUR,RUB|
|EUR|150.00|ПриватБанк|UAH,USD,RUB|
|EUR|300.00|Средний курс|UAH,USD,RUB|
|RUB|150.00|Средний курс|UAH,USD,EUR|
|RUB|250.00|ПриватБанк|UAH,USD,EUR|
|UAH|300.00|ПриватБанк|USD,EUR,RUB|
|UAH|300.00|Средний курс|USD,EUR,RUB|