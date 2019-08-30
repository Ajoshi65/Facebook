package test;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features ="C:\\Users\\AnamikaJoshi\\Desktop\\BaseFramework\\FB\\feature",glue={"stepDefinations"})

@Test
public class TestRunner extends AbstractTestNGCucumberTests
{

}
