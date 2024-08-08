package com.store.PageObject;

import org.openqa.selenium.WebDriver; // Import WebDriver interface for controlling the browser
import org.openqa.selenium.chrome.ChromeDriver; // Import ChromeDriver for controlling Google Chrome
import org.openqa.selenium.edge.EdgeDriver; // Import EdgeDriver for controlling Microsoft Edge
import org.openqa.selenium.firefox.FirefoxDriver; // Import FirefoxDriver for controlling Mozilla Firefox

public class SelectBrowserBase {
    // Protected WebDriver variable to be used by subclasses
    protected static WebDriver driver;
    
    // Constructor to initialize WebDriver
    public SelectBrowserBase(WebDriver driver) {
        this.driver = driver; // Set the WebDriver instance for this class
    }
    
    // Method to select and initialize browser 
    public static WebDriver selectBrowser(String browserName) {
        
        // Check if the browserName is "chrome"
        if (browserName.equalsIgnoreCase("chrome")) {
        	
            driver = new ChromeDriver();// Initialize ChromeDriver
            driver.manage().window().maximize(); // Maximize the browser window
            driver.get("https://www.demoblaze.com/");  // Navigate to the website
            
        } else if (browserName.equalsIgnoreCase("firefox")) {
           
            driver = new FirefoxDriver(); 
            driver.manage().window().maximize();
            driver.get("https://www.demoblaze.com/"); 
            
        } else if (browserName.equalsIgnoreCase("edge")) {
           
            driver = new EdgeDriver(); 
            driver.manage().window().maximize(); 
            driver.get("https://www.demoblaze.com/");
            
        } else {
            // Print an error message if the browser is not found
            System.out.println("Sorry! Browser not found.");
        }
        return driver; // Return the WebDriver instance
    }
}
