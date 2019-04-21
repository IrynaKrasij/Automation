package steps;

import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.RozetkaMainPage;
import sun.rmi.runtime.Log;


public class RozetkaMainSteps {


    private RozetkaMainPage rozetkaMainPage;
    private static final Logger LOG = LoggerFactory.getLogger(CurrencyConverterSteps.class.getSimpleName());

    @Step
    public void user_opens_rozetka_main_page() {
        LOG.info("Open rozetka main page");
        rozetkaMainPage.open();
    }

    @Step
    public void user_clicks_on_personal_cabinet_link() {
        LOG.info("Click on personal link");
        rozetkaMainPage.clickPersonalCabinetLink();
    }

    @Step
    public void user_puts_login_name_value(final String loginName) {
        LOG.info("Type login name value in login field");
        rozetkaMainPage.typeLoginNameValueInLoginField(loginName);
    }

    @Step
    public void user_puts_password_value(final String password) {
        LOG.info("Type password value in password field");
        rozetkaMainPage.typePasswordValueInPasswordField(password);
    }

    @Step
    public void user_clicks_on_login_button() {
        LOG.info("Click on login button");
        rozetkaMainPage.clickOnLoginButton();
    }

    public void user_verifies_value_on_the_page(final String personalName) {
        LOG.info("Verify received result");
        rozetkaMainPage.verifyValueOnThePage(personalName);
    }
}