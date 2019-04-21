Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: scenario description
Given User opens rozetka main page
When User clicks on personal cabinet link
And User puts <loginName> value in login field
And User puts <password> value in password field
And User clicks on login button
Then User verifies visibility of <personalName> value on the page

Examples:
|loginName|password|personalName|
|irena_krasiy@ukr.net|Moonwalk1|Ірина Красій|
