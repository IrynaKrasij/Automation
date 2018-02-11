package stepdefinitions;

import net.serenitybdd.jbehave.SerenityStories;

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
