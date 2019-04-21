package stepdefinitions;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import steps.RozetkaMainSteps;

public class RozetkaMainDefinitionSteps {

    @Steps
    private RozetkaMainSteps rozetkaMainSteps;

    @Given("User opens rozetka main page")
    public void openRozetkaMainPage(){
        rozetkaMainSteps.user_opens_rozetka_main_page();
    }

    @When("User clicks on personal cabinet link")
    public void openPersonalCabinetPage(){
        rozetkaMainSteps.user_clicks_on_personal_cabinet_link();
    }

    @When("User puts $loginName value in login field")
    public void putLoginNameValue(final String loginName){
        rozetkaMainSteps.user_puts_login_name_value(loginName);
    }

    @When("User puts $password value in password field")
    public void putPasswordValue(final String password){
        rozetkaMainSteps.user_puts_password_value(password);
    }

    @When("User clicks on login button")
    public void clickOnLoginButton(){
        rozetkaMainSteps.user_clicks_on_login_button();
    }

    @Then("User verifies visibility of $personalName value on the page")
    public void verifyValueOnThePage(final String personalName){
        rozetkaMainSteps.user_verifies_value_on_the_page(personalName);
    }
}
