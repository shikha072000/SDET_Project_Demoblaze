package com.store.TestCases;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.store.PageObject.SelectBrowserBase;

public class Baseclass {
    WebDriver driver; // WebDriver instance for controlling the browser
    ExtentReports extent; // ExtentReports instance for generating test reports
    ExtentTest test; // ExtentTest instance for creating test cases in the report
    Properties props; // Properties instance for loading configuration files
    SelectBrowserBase selectBrowserBase; // SelectBrowserBase instance for browser setup

    @BeforeClass
    public void setup() throws FileNotFoundException, IOException {
        // Create an instance of ExtentSparkReporter to generate an HTML report
        ExtentSparkReporter spark = new ExtentSparkReporter("./extent-reports/extent-report.html");
        extent = new ExtentReports(); // Initialize ExtentReports
        extent.attachReporter(spark); // Attach the reporter to ExtentReports
        selectBrowserBase = new SelectBrowserBase(driver); // Initialize SelectBrowserBase with WebDriver instance
        // Select and initialize the browser
        driver = SelectBrowserBase.selectBrowser("chrome");
        props = new Properties(); // Initialize Properties
        props.load(new FileInputStream("./src/test/java/data.properties")); // Load properties from file
        // Navigate to the website
        driver.navigate().to("https://www.demoblaze.com/");
        driver.manage().window().maximize(); // Maximize the browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set implicit wait timeout
    }

    @BeforeMethod
    public void beforeMethod() {
        test = extent.createTest("Test Case: " + this.getClass().getName()); // Create a new test entry in the report
    }

    @AfterMethod
    public void afterMethod() {
        extent.flush(); // Flush the report to save all logs and results
    }

    @AfterClass
    public void close() {
        driver.quit(); // Close the browser and quit WebDriver
        extent.flush(); // Flush the report to save all logs and results
    }

    // Method to take a screenshot and save it to a file
    public void takeScreenshot(String fileName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // Take screenshot
        FileHandler.copy(screenshot, new File("./screenshots/" + fileName + ".png")); // Save screenshot to file
    }
}