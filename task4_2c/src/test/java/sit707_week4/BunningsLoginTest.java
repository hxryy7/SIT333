package sit707_week4;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

/**
 * Selenium-based UI testing for Bunnings login page.
 * Covers cases based on decision table: valid/invalid/empty credentials.
 */
public class BunningsLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver"); // Update path if needed
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.bunnings.com.au/login");
    }

    @Test
    public void testEmptyUsernameAndPassword() {
        driver.findElement(By.id("login-submit")).click();
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login-form__error")));
        Assert.assertTrue("Error should be displayed for empty credentials", error.isDisplayed());
    }

    @Test
    public void testEmptyUsernameValidPassword() {
        driver.findElement(By.id("password")).sendKeys("Vardaan$1");
        driver.findElement(By.id("login-submit")).click();
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login-form__error")));
        Assert.assertTrue("Error should be displayed for empty username", error.isDisplayed());
    }

    @Test
    public void testValidUsernameEmptyPassword() {
        driver.findElement(By.id("username")).sendKeys("vardaanchahal2004@gmail.com");
        driver.findElement(By.id("login-submit")).click();
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login-form__error")));
        Assert.assertTrue("Error should be displayed for empty password", error.isDisplayed());
    }

    @Test
    public void testInvalidUsernameValidPassword() {
        driver.findElement(By.id("username")).sendKeys("wrong@example.com");
        driver.findElement(By.id("password")).sendKeys("Vardaan$1");
        driver.findElement(By.id("login-submit")).click();
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login-form__error")));
        Assert.assertTrue("Error should be displayed for invalid username", error.isDisplayed());
    }

    @Test
    public void testValidUsernameInvalidPassword() {
        driver.findElement(By.id("username")).sendKeys("vardaanchahal2004@gmail.com");
        driver.findElement(By.id("password")).sendKeys("wrongpass");
        driver.findElement(By.id("login-submit")).click();
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login-form__error")));
        Assert.assertTrue("Error should be displayed for invalid password", error.isDisplayed());
    }

    @Test
    public void testValidUsernameAndPassword() {
        driver.findElement(By.id("username")).sendKeys("vardaanchahal2004@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Vardaan$1");
        driver.findElement(By.id("login-submit")).click();

        wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("login")));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse("User should be redirected after successful login", currentUrl.contains("login"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}