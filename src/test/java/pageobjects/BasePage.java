package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.concurrent.TimeUnit;

public class BasePage extends PageObject {

    public boolean isElementVisible(final boolean expectedResult, final WebElementFacade... elements) {
        boolean result = true;
        for (WebElementFacade el : elements) {
            if (expectedResult) {
                result = result && el.isVisible();
            } else {
                setImplicitTimeout(50, TimeUnit.MILLISECONDS);
                result = result && el.isPresent() && el.isCurrentlyVisible();
                resetImplicitTimeout();
            }
        }
        return result;
    }
}
