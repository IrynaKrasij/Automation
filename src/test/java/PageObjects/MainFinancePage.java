package PageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@DefaultUrl("https://finance.i.ua/")
public class MainFinancePage extends PageObject {

    @FindBy(xpath="//a[contains(text(),'Конвертер валют')]")
    WebElementFacade converterLink;


    public void openMainFinancePage(){
       this.open();
    }

    public void openConverterCurrencyPage(){
        converterLink.click();
    }
}
