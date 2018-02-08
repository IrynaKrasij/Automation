package StepsDefinition;

import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/13/2015.
 */
public class RunTest extends SerenityStories {
    public RunTest(){
        findStoriesCalled(System.getProperty("story"));
    }

    @Override
    public void run() throws Throwable {
        super.run();
    }

}
