package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationServiceTest {

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void performRegistrationTest(String fname, String lname, String email, String dob, String expectedTitle) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gsirp\\Desktop\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            System.out.println("Starting test with: " + fname + ", " + lname + ", " + email + ", " + dob);
            driver.navigate().to("file:///C:/Users/gsirp/Documents/Software%20quality%20and%20testing/Task%207/Task7_1p/7.2D-resources/webservice1/register.html");

//            sleep(2);

            driver.findElement(By.id("fname")).sendKeys(fname);
//            sleep(1);

            driver.findElement(By.id("lname")).sendKeys(lname);
//            sleep(1);
//
            driver.findElement(By.id("email")).sendKeys(email);
//            sleep(1);

            driver.findElement(By.id("dob")).sendKeys(dob);
//            sleep(1);

            driver.findElement(By.cssSelector("input[type=submit]")).click();
            sleep(2);

            String title = driver.getTitle();
            System.out.println("Expected Title: " + expectedTitle + " | Actual Title: " + title);

            Assert.assertEquals(expectedTitle, title);
            System.out.println("Test Passed");
        } catch (Exception e) {
            System.out.println("Test Failed due to exception: " + e.getMessage());
            throw e; // rethrow to let JUnit handle it
        } finally {
            driver.quit(); // Always quit browser
        }
    }

    @Test
    public void testValidRegistration() {
        performRegistrationTest("Girish", "Sirpali", "girish@gmail.com", "05-11-2004", "success");
    }

    @Test
    public void testMissingFirstName() {
        performRegistrationTest("", "Sirpali", "girish@gmail.com", "2004-05-11", "fail");
    }

    @Test
    public void testInvalidEmail() {
        performRegistrationTest("Girish", "Sirpali", "invalid-email", "2004-05-11", "fail");
    }

    @Test
    public void testEmptyFields() {
        performRegistrationTest("", "", "", "", "fail");
    }

    @Test
    public void testMissingDOB() {
        performRegistrationTest("Girish", "Sirpali", "girish@gmail.com", "", "fail");
    }

    @Test
    public void testMinimalValidInput() {
        performRegistrationTest("A", "B", "a@b.co", "2000-01-01", "success");
    }

}