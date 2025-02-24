package Test;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"Test"},
        //tags = "@Login",
        monochrome = true,
        plugin = {
            "pretty",
             
            "html:target/cucumber-reports/html-report.html",
            "json:target/cucumber-reports/cucumber-report.json",
            "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" 
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    public String toString() {
        return "TestRunner []";
    }
}
