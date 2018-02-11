package pageobjects;

import enums.Key;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.ui.Select;
import utils.Session;


@DefaultUrl("https://finance.i.ua/converter/")
public class CurrencyConverterPage extends PageObject {

    @FindBy(xpath = "//li[@id='sell']/a")
    private WebElementFacade sellLink;

    @FindBy(xpath = "//li[@id='buy']/a")
    private WebElementFacade buyLink;

    @FindBy(xpath = "//select[@id='converter_currency']")
    private WebElementFacade currencyDropdown;

    @FindBy(xpath = "//input[@id='currency_amount']")
    private WebElementFacade currencyAmountField;

    @FindBy(xpath = "//select[@id='converter_bank']")
    private WebElementFacade rateDropdown;

    @FindBy(xpath = "//p[@id='UAH']/input[@id='currency_exchange']")
    private WebElementFacade uahValueField;

    @FindBy(xpath = "//p[@id='USD']/input[@id='currency_exchange']")
    private WebElementFacade usdValueField;

    @FindBy(xpath = "//p[@id='EUR']/input[@id='currency_exchange']")
    private WebElementFacade eurValueField;

    @FindBy(xpath = "//p[@id='RUB']/input[@id='currency_exchange']")
    private WebElementFacade rubValueField;

    @FindBy(xpath="//p[@id='UAH']/input[@id='currency_rate']")
    private WebElementFacade uahRateField;

    @FindBy(xpath="//p[@id='EUR']/input[@id='currency_rate']")
    private WebElementFacade eurRateField;

    @FindBy(xpath="//p[@id='USD']/input[@id='currency_rate']")
    private WebElementFacade usdRateField;

    @FindBy(xpath="//p[@id='RUB']/input[@id='currency_rate']")
    private WebElementFacade rubRateField;

    @FindBy(xpath = "//div[@class='widget-currency_bank']//tr[./th[text()='USD']]/td[1]/span/span[1]")
    private WebElementFacade usdBuyingRateLabel;

    @FindBy(xpath = "//div[@class='widget-currency_bank']//tr[./th[text()='USD']]/td[2]/span/span[1]")
    private WebElementFacade usdSellingRateLabel;

    @FindBy(xpath = "//div[@class='widget-currency_bank']//tr[./th[text()='EUR']]/td[1]/span/span[1]")
    private WebElementFacade eurBuyingRateLabel;

    @FindBy(xpath = "//div[@class='widget-currency_bank']//tr[./th[text()='EUR']]/td[2]/span/span[1]")
    private WebElementFacade eurSellingRateLabel;

    @FindBy(xpath = "//div[@class='widget-currency_bank']//tr[./th[text()='RUB']]/td[1]/span/span[1]")
    private WebElementFacade rubBuyingRateLabel;

    @FindBy(xpath = "//div[@class='widget-currency_bank']//tr[./th[text()='RUB']]/td[2]/span/span[1]")
    private WebElementFacade rubSellingRateLabel;

    public void clickSellLink() {
        sellLink.click();
    }

    public void clickBuyLink() {
        buyLink.click();
    }

    public String getUahRateFieldText() {
        return uahRateField.getValue();
    }

    public String getEurRateFieldText() {
        return eurRateField.getValue();
    }

    public String getUsdRateFieldText() {
        return usdRateField.getValue();
    }

    public String getRubRateFieldText() {
        return rubRateField.getValue();
    }

    public String getUsdSellingRateLabelText() {
        return usdSellingRateLabel.getText();
    }

    public String getUsdBuyingRateLabelText() {
        return usdBuyingRateLabel.getText();
    }

    public String getEurBuyingRateLabelText() {
        return eurBuyingRateLabel.getText();
    }

    public String getEurSellingRateLabelText() {
        return eurSellingRateLabel.getText();
    }

    public String getRubBuyingRateLabelText() {
        return rubBuyingRateLabel.getText();
    }

    public String getRubSellingRateLabelText() {
        return rubSellingRateLabel.getText();
    }

    public String getUsdValueFieldText() {
        return usdValueField.getValue();
    }

    public String getEurValueFieldText() {
        return eurValueField.getValue();
    }

    public String getRubValueFieldText() {
        return rubValueField.getValue();
    }

    public String getUahValueFieldText() {
        return uahValueField.getValue();
    }

    public void selectCurrencyDropdownValue(final String currencyName) {
        Select select = new Select(currencyDropdown);
        select.selectByVisibleText(currencyName);
    }

    public void typeCurrencyAmountFieldValue(final Double currencyAmount) {
        currencyAmountField.clear();
        currencyAmountField.type(currencyAmount.toString());
        Session.put(Key.CURRENCY_AMOUNT, currencyAmount);
    }

    public void selectRateDropdownValue(final String rateValue) {
        Select select = new Select(rateDropdown);
        select.selectByVisibleText(rateValue);
    }
}
