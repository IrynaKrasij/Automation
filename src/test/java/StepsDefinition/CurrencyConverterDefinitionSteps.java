package StepsDefinition;

import Steps.CurrencyConverterSteps;
import enums.Currency;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.List;

public class CurrencyConverterDefinitionSteps {

    @Steps
    private CurrencyConverterSteps currencyConverterSteps;

    /**
     * CurrencyConverterDefinitionSteps
     **/

    @Given("User opens currency converter page")
    public void openConverterPage(){
        currencyConverterSteps.userOpensConverterPage();
    }

    @When("User clicks on sell option link")
    public void clickSellOption(){
        currencyConverterSteps.user_selects_sell_option();
    }

    @When("User clicks on buy option link")
    public void clickBuyOption(){
        currencyConverterSteps.user_selects_buy_option();
    }

    @When("User selects $currencyName currency from dropdown list")
    public void selectUsdText(final Currency currencyName){
        currencyConverterSteps.user_selects_currency_from_dropdown_list(currencyName);
    }

    @When("User puts $currencyAmount value of currency amount in sum field")
    public void putCurrencyAmount(final Double currencyAmount){
        currencyConverterSteps.user_puts_currency_amount_in_sum_field(currencyAmount);
    }

    @When("User selects $rateValue rate value from dropdown list")
    public void selectRateValue(final String rateValue){
        currencyConverterSteps.user_selects_rate_value_from_dropdown_list(rateValue);
    }

    @Then("User checks results for the list of currency $currencyList")
    public void checkResultsForCurrencyList(final List<Currency> currencyList) throws Exception {
        currencyConverterSteps.user_checks_result_for_currency_list(currencyList);
    }
}
