package web.service;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceUnitTest {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
            "/Users/vardaan/Downloads/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to(
            "file:////Users/anshpreetsingh/Downloads/java_projects/task_7_1P/pages/login.html");
    }

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void submitLogin(String username, String password, String dob) {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);

        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(password);

        driver.findElement(By.id("dob")).clear();
        driver.findElement(By.id("dob")).sendKeys(dob);

        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(2);
    }

    // Confirm successful login with all correct inputs
    @Test
    public void shouldNavigateToSuccessPageOnValidLogin() {
        submitLogin("anshpreet", "anshpreet", "11-09-2004");
        Assert.assertEquals("success", driver.getTitle());
    }

    // Reject login when username is incorrect
    @Test
    public void shouldStayOnFailPageForInvalidUsername() {
        submitLogin("wrongUser", "pass123", "2000-01-01");
        Assert.assertEquals("fail", driver.getTitle());
    }

    // Reject login when password is incorrect
    @Test
    public void shouldStayOnFailPageForInvalidPassword() {
        submitLogin("john", "wrongpass", "2000-01-01");
        Assert.assertEquals("fail", driver.getTitle());
    }

    // Reject login when date of birth is incorrect
    @Test
    public void shouldStayOnFailPageForInvalidDob() {
        submitLogin("john", "pass123", "1999-01-01");
        Assert.assertEquals("fail", driver.getTitle());
    }

    // Reject login when username field is empty
    @Test
    public void shouldFailWhenUsernameEmpty() {
        submitLogin("", "pass123", "2000-01-01");
        Assert.assertEquals("fail", driver.getTitle());
    }

    // Reject login when password field is empty
    @Test
    public void shouldFailWhenPasswordEmpty() {
        submitLogin("john", "", "2000-01-01");
        Assert.assertEquals("fail", driver.getTitle());
    }

    // Reject login when DOB field is empty
    @Test
    public void shouldFailWhenDobEmpty() {
        submitLogin("john", "pass123", "");
        Assert.assertEquals("fail", driver.getTitle());
    }

    // Reject login when every field is empty
    @Test
    public void shouldFailWhenAllFieldsEmpty() {
        submitLogin("", "", "");
        Assert.assertEquals("fail", driver.getTitle());
    }

    // Reject login when all inputs are malformed
    @Test
    public void shouldFailWhenAllInputsInvalid() {
        submitLogin("abc123", "!@#$$", "1900-01-01");
        Assert.assertEquals("fail", driver.getTitle());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
