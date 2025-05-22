package test.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

/**
 * End-to-end tests for the Spring-Boot quiz using Selenium.
 * Requires the app to be running on http://localhost:8080/ beforehand:
 *
 *     mvn spring-boot:run
 */
public class LoginSeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final String BASE = "http://localhost:8080";

    @Before
    public void setUp() {
        // Automatically download the right ChromeDriver and put it on PATH
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait   = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    /* ---------- smoke ---------- */

    @Test
    public void testSanity() {
        driver.get(BASE + "/login");
        assertEquals(BASE + "/login", driver.getCurrentUrl());
    }

    /* ---------- login ---------- */

    @Test
    public void testValidLogin() {
        driver.get(BASE + "/login");
        driver.findElement(By.name("username")).sendKeys("ahsan");
        driver.findElement(By.name("passwd" )).sendKeys("ahsan_pass");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Wait until we're on Q1 page
        WebElement h2 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
        assertTrue(h2.getText().startsWith("Question 1"));
    }

    @Test
    public void testInvalidLogin() {
        driver.get(BASE + "/login");
        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("passwd")).sendKeys("bad");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Should still be on /login
        wait.until(ExpectedConditions.urlContains("/login"));
        assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }

    /* ---------- quiz flow helper ---------- */

    private void answerQ1Correctly() {
        driver.findElement(By.name("number1")).sendKeys("3");
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result" )).sendKeys("7");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        wait.until(ExpectedConditions.urlContains("/q2"));
    }

    /* ---------- sample Q1 happy-path test ---------- */

    @Test
    public void testQ1_CorrectAnswer() {
        testValidLogin();      // login first
        answerQ1Correctly();   // now on /q2
        WebElement h2 = driver.findElement(By.tagName("h2"));
        assertTrue(h2.getText().startsWith("Question 2"));
    }

    /* ---------- teardown ---------- */

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
