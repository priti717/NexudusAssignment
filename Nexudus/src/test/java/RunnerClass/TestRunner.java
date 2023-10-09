package RunnerClass;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // format = {"pretty", "html:target/Destination"},

        features = {"C:\\Users\\welcome\\IdeaProjects\\Nexudus\\src\\test\\java\\Features\\Loginpage.feature"},
        glue={"StepDefinations"},
        monochrome = true,//display the console output in a proper readable format
        plugin = {"pretty","html:target/cucumber-reports/report.html", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"} //to generate different types of reporting
        // strict = true //it will check if any step is not defined in step definition file
      ,tags = "@Sanity"

)

public class TestRunner {

}
