package com.store.TestCases;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

public class CartPage extends Baseclass 
{
	// Test case to verify add to cart functionality
    @Test
    public void testCartFunction() throws InterruptedException, IOException {
            // Add product to the cart
            driver.findElement(By.linkText("Laptops")).click();
            Thread.sleep(2000);
            driver.findElement(By.linkText("MacBook air")).click();
            Thread.sleep(2000);
            //click add to cart button
            driver.findElement(By.linkText("Add to cart")).click();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            driver.findElement(By.xpath("//a[@id='cartur']")).click();
            
            //take Screenshot
            takeScreenshot("cartpage");
            test.log(Status.PASS, "Login successful").addScreenCaptureFromPath("Screenshots/cartpage.png");
            Thread.sleep(2000);
        }
}