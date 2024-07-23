package com.demo.webshopautomation.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/demo/webshopautomation/features",
        glue = "steps",
        plugin = {"com.aventstack.extentreports:html"},
        monochrome = true,
        publish = true)
public class TestRunner extends AbstractTestNGCucumberTests { }