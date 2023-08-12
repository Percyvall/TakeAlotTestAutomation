package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
       features = {"src//test//resources//Features//takeALot.Feature"},
        glue = {"Stepdefenition"},
        plugin = {"json:target/cucumber.json"}
)
public class RunnerTest {
    @AfterClass
    public static void writeExtentReport() {
        //Reporter.loadXMLConfig(new File("src/test/resources/config/extent-config.xml"));
    }
}
