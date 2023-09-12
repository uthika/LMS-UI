package testrunners;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.CucumberOptions;

;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"@target/failed_scenarios.txt"},
		glue = {"com.stepdefinitions","AppHooks"},
		tags = " ",
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/","html:target/cucumber-reports.html"
		},
		monochrome=true
		)

public class FailedTestRunner extends AbstractTestNGCucumberTests {
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
				
		return super.scenarios();
    }
	
}

