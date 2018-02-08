package Steps;

import PageObjects.CurrencyConverterPage;
import PageObjects.MainFinancePage;
import enums.Currency;
import enums.Key;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import utils.Session;

import java.text.DecimalFormat;
import java.util.List;

public class CurrencyConverterSteps{

    MainFinancePage mainFinancePage;
    CurrencyConverterPage currencyConverterPage;

    @Step
    public void userOpensConverterPage() {
        currencyConverterPage.open();
    }

    @Step
    public void user_selects_sell_option() {
        currencyConverterPage.clickSellLink();
    }

    @Step
    public void user_selects_buy_option() {
        currencyConverterPage.clickBuyLink();
    }

    @Step
    public void user_selects_currency_from_dropdown_list(final Currency currency) {
        currencyConverterPage.selectCurrencyDropdownValue(currency.toString());
    }

    @Step
    public void user_puts_currency_amount_in_sum_field(final Double currencyAmount) {
        currencyConverterPage.typeCurrencyAmountFieldValue(currencyAmount);
    }

    @Step
    public void user_selects_rate_value_from_dropdown_list(final String rateValue) {
        currencyConverterPage.selectRateDropdownValue(rateValue);
    }

    @Step
    public void user_checks_result_for_currency_list(final List<Currency> currencyList) throws Exception {
        SoftAssertions softAssertions = new SoftAssertions();
        DecimalFormat df = new DecimalFormat("0.00");
        for (Currency currency : currencyList) {
            Double expectedValue;
            Double uahRateValue = Double.valueOf(currencyConverterPage.getUahRateFieldText());
            Double eurRateValue = Double.valueOf(currencyConverterPage.getEurRateFieldText());
            Double rubRateValue = Double.valueOf(currencyConverterPage.getRubRateFieldText());
            String actualValue;
            Double initialCurrencyAmount = (Double) Session.get(Key.CURRENCY_AMOUNT);
            switch (currency) {
                case UAH:
                    expectedValue = initialCurrencyAmount * uahRateValue;
                    actualValue = currencyConverterPage.getUahValueFieldText();
                    break;
                case EUR:
                    expectedValue = initialCurrencyAmount * uahRateValue / eurRateValue;
                    actualValue = currencyConverterPage.getEurValueFieldText();
                    break;
                case USD:
                    expectedValue = initialCurrencyAmount * uahRateValue;;
                    actualValue = currencyConverterPage.getUsdValueFieldText();
                    break;
                case RUB:
                    expectedValue = initialCurrencyAmount * uahRateValue / rubRateValue;;
                    actualValue = currencyConverterPage.getRubValueFieldText();
                    break;
                default:
                    throw new Exception("Unsupported currency: " + currency);
            }
            String a = actualValue.replace(" ", "");
            String b = df.format(expectedValue).replace(",", ".");
            softAssertions.assertThat(a).as("Incorrect converted value for '"
                    + currency+"' currency").isEqualTo(b);
        }
        softAssertions.assertAll();
    }
}
