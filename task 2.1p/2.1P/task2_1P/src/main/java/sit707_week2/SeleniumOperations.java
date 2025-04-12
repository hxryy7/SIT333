package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Selenium automation for Officeworks registration page.
 * It fills out the registration form, submits it, and captures a screenshot.
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

    /**
     * Helper method to pause execution for a few seconds.
     * @param sec Number of seconds to sleep.
     */
    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Automates the Officeworks registration page.
     * Opens the URL, fills in the form, clicks submit, and takes a screenshot.
     * 
     * @param url The URL of the registration page.
     */
    public static void officeworks_registration_page(String url) {
        // Set ChromeDriver path (Change this to your actual path)
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");

        // Launch the Chrome browser
        System.out.println("Launching Chrome browser...");
        WebDriver driver = new ChromeDriver();
        sleep(2);

        // Open the registration page
        driver.get(url);
        System.out.println("Opened URL: " + url);
        sleep(2);

        try {
            // Locate and enter first name
            WebElement firstName = driver.findElement(By.id("firstname"));
            firstName.sendKeys("Ahsan");
            System.out.println("Entered First Name");

            // Locate and enter last name
            WebElement lastName = driver.findElement(By.id("lastname"));
            lastName.sendKeys("Habib");
            System.out.println("Entered Last Name");

            // Locate and enter email
            WebElement email = driver.findElement(By.id("email"));
            email.sendKeys("ahsan@example.com");
            System.out.println("Entered Email");

            // Locate and enter phone number
            WebElement phone = driver.findElement(By.id("phoneNumber"));
            phone.sendKeys("0412345678");
            System.out.println("Entered Phone Number");

            // Locate and enter password
            WebElement password = driver.findElement(By.name("password"));
            password.sendKeys("WeakPass123"); // Weak password to trigger an error
            System.out.println("Entered Password");

            // Locate and enter confirm password
            WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
            confirmPassword.sendKeys("WeakPass123");
            System.out.println("Entered Confirm Password");

            // Locate and click the "Create Account" button
//            WebElement createAccountButton = driver.findElement(By.id("create-account"));
//            createAccountButton.click();
//            System.out.println("Clicked Create Account Button");

            sleep(3); // Wait for the error message to be displayed

            // Take a screenshot after submission failure
            takeScreenshot(driver, "bunnings.png");
            System.out.println("Screenshot captured");

        } catch (Exception e) {
            System.out.println("Error encountered: " + e.getMessage());
        }

        // Close the browser
        sleep(2);
        //driver.quit();
        System.out.println("Closed the browser");
    }

    /**
     * Takes a screenshot using Selenium and saves it as a PNG file.
     * @param driver The WebDriver instance.
     * @param fileName The name of the output file.
     */
    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            // Capture the screenshot as bytes
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            // Save the screenshot manually
            File screenshotFile = new File(fileName);
            FileOutputStream fos = new FileOutputStream(screenshotFile);
            fos.write(screenshotBytes);
            fos.close();
            
            System.out.println("Screenshot saved as: " + fileName);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
