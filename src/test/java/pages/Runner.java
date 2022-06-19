package pages;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)



@CucumberOptions(
        plugin = {},
        features = {"src/test/resources/features/"},
        glue = {"steps"},

        //  monochrome= true,
        tags = ""


)
public class Runner {
    @AfterClass
    public static void clearDriver() {
        BasePage.closeBrowser();
    }

}



