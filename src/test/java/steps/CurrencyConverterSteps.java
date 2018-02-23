package steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.CurrencyConverterPage;
import enums.Currency;
import enums.Key;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import utils.Session;

import java.text.DecimalFormat;
import java.util.List;

public class CurrencyConverterSteps{

    private CurrencyConverterPage currencyConverterPage;
    private static final Logger LOG = LoggerFactory.getLogger(CurrencyConverterSteps.class.getSimpleName());

    @Step
    public void userOpensConverterPage() {
        LOG.info("Open currency converter page");
        currencyConverterPage.open();
    }

    @Step
    public void user_selects_sell_option() {
        LOG.info("Select 'sell' option");
        currencyConverterPage.clickSellLink();
    }

    @Step
    public void user_selects_buy_option() {
        LOG.info("Select 'buy' option");
        currencyConverterPage.clickBuyLink();
    }

    @Step
    public void user_selects_currency_from_dropdown_list(final Currency currency) {
        LOG.info("Select '" + currency + "' currency from the list");
        currencyConverterPage.selectCurrencyDropdownValue(currency.toString());
        Session.put(Key.CURRENCY_NAME, currency);
    }

    @Step
    public void user_puts_currency_amount_in_sum_field(final Double currencyAmount) {
        LOG.info("Put currency amount");
        currencyConverterPage.typeCurrencyAmountFieldValue(currencyAmount);
    }

    @Step
    public void user_selects_rate_value_from_dropdown_list(final String rateValue) {
        LOG.info("Select '" + rateValue + "' rate value from the list");
        currencyConverterPage.selectRateDropdownValue(rateValue);
    }

    @Step
    public void user_checks_result_for_currency_list(final List<Currency> currencyList) throws Exception {
        LOG.info("Check received results");
        SoftAssertions softAssertions = new SoftAssertions();
        DecimalFormat df = new DecimalFormat("0.00");
        for (Currency currency : currencyList) {
            Double expectedValue = 0.0;
            Double uahRateValue  = 0.0;
            if (Currency.UAH.equals(Session.get(Key.CURRENCY_NAME))) {
                uahRateValue = 1.0;
            }
            else {
                uahRateValue = Double.valueOf(currencyConverterPage.getUahRateFieldText());
            }
            String actualValue;
            Double initialCurrencyAmount = (Double) Session.get(Key.CURRENCY_AMOUNT);
            switch (currency) {
                case UAH:
                    expectedValue = initialCurrencyAmount * uahRateValue;
                    actualValue = currencyConverterPage.getUahValueFieldText();
                    break;
                case EUR:
                    Double eurRateValue = Double.valueOf(currencyConverterPage.getEurRateFieldText());
                    expectedValue = initialCurrencyAmount * uahRateValue / eurRateValue;
                    actualValue = currencyConverterPage.getEurValueFieldText();
                    break;
                case USD:
                    Double usdRateValue = Double.valueOf(currencyConverterPage.getUsdRateFieldText());
                    expectedValue = initialCurrencyAmount * uahRateValue / usdRateValue;
                    actualValue = currencyConverterPage.getUsdValueFieldText();
                    break;
                case RUB:
                    Double rubRateValue = Double.valueOf(currencyConverterPage.getRubRateFieldText());
                    expectedValue = initialCurrencyAmount * uahRateValue / rubRateValue;
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
