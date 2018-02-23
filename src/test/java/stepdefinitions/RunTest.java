package stepdefinitions;

import net.serenitybdd.jbehave.SerenityStories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.LocalProperties;

/**
 * Created by Administrator on 11/13/2015.
 */
public class RunTest extends SerenityStories {

    private static final Logger LOG = LoggerFactory.getLogger(SerenityStories.class.getSimpleName());

    public RunTest(){
        LocalProperties.propertiesFromFile();
        findStoriesCalled(System.getProperty("story"));
    }

    @Override
    public void run() throws Throwable {
        super.run();
    }

}
