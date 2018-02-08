Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: VerifySellingUSDByOTPBankRate
Given I am on a Converter currency page
When I select sell option
And I select USD currency
And I put a sum in a Sum field
And I select OTPBank rate
Then Result fields are populated