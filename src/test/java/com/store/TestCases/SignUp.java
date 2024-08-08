package com.store.TestCases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

public class SignUp extends Baseclass {
    
    // Test case to verify signup functionality
    @Test
    public void testSignUpFunction() throws InterruptedException, IOException {
        // Click on the "Sign up" button to open the sign-up form
        driver.findElement(By.linkText("Sign up")).click();
        Thread.sleep(2000); // Wait for 2 seconds to allow the sign-up page to load

        // Fill in the sign-up form with a unique username and password
        driver.findElement(By.id("sign-username")).sendKeys("Shikhanigam" + System.currentTimeMillis()); // Enter a unique username with timestamp
        driver.findElement(By.id("sign-password")).sendKeys("shikha123"); // Enter the password
        
        // Click on the "Sign up" button to submit the form
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
        
        // Take a screenshot of the sign-up page
        takeScreenshot("signpage"); // Save the screenshot with the name "signpage"
        // Log the result in the ExtentReports and attach the screenshot
        Thread.sleep(2000); // Wait for 2 seconds to ensure the alert is visible
    
        // Handle the alert that appears after sign-up
        String alertText = driver.switchTo().alert().getText(); // Get the text of the alert
        // Assert that the alert text contains the expected message
        Assert.assertTrue(alertText.contains("Sign up successful"), "Alert text did not match expected value!");
        driver.switchTo().alert().accept(); // Accept the alert to close it
    }
}