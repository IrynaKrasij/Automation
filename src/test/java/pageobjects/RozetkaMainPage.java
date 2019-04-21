package pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class RozetkaMainPage extends BasePage {


    @FindBy(xpath = "//span[@id='header_user_menu_parent']/a")
    WebElementFacade personalCabinetLink;

    @FindBy(xpath = "//span[contains(text(),'Каталог товаров')]/..")
    WebElementFacade productCatalogButton;

    @FindBy(xpath = "//div[@name='rz-header-search-input-text-wrap']/input")
    WebElementFacade searchField;

    @FindBy(xpath = "//input[@name='login']")
    WebElementFacade loginField;

    @FindBy(xpath = "//input[@name='password']")
    WebElementFacade passwordField;

    @FindBy(xpath = "//button[@name='auth_submit']")
    WebElementFacade submitButton;


    public void clickPersonalCabinetLink() {
        personalCabinetLink.click();
    }

    public void typeLoginNameValueInLoginField(final String loginName) {
        loginField.clear();
        typeInto(loginField, loginName);
    }

    public void typePasswordValueInPasswordField(final String password) {
        passwordField.clear();
        typeInto(passwordField, password);
    }

    public void clickOnLoginButton() {
        submitButton.click();
    }

    public void verifyValueOnThePage(String personalName) {

    }
}
