package test.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/test/cucumber/features",
        glue = "test.cucumber.step",
//        tags = "@saucedemo",
//        monochrome = true,
        plugin = {"html:target/HTML_report.html"}
)
public class saucedemo {

}
