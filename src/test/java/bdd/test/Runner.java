package bdd.test;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;


@CucumberOptions(features="./src/test/resources/feature",
					glue = {"bdd.test","hooks"},
					//dryRun =true,
					snippets = SnippetType.CAMELCASE,
					plugin = { "pretty", 
							"html:target/cucumber-reports/cucumber-pretty.html",
							"json:target/cucumber-reports/CucumberTestReport.json",
							"rerun:target/cucumber-reports/rerun.txt",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
							,tags = "@addcustomer")
public class Runner extends AbstractTestNGCucumberTests {
			
}
