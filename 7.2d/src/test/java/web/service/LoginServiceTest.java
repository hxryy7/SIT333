package web.service;

import javax.servlet.annotation.WebServlet;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@WebServlet("/login")
public class LoginServiceTest {

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void performLoginTest(String username, String password, String dob, String expectedTitle) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gsirp\\Desktop\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///C:/Users/gsirp/Documents/Software%20quality%20and%20testing/Task%207/Task7_1p/7.1P-resources/webservice1/login.html");

        sleep(2);

        driver.findElement(By.id("username")).sendKeys(username);
        sleep(1); // Slow down between fields

        driver.findElement(By.id("passwd")).sendKeys(password);
        sleep(1); // Slow down between fields

        driver.findElement(By.id("dob")).sendKeys(dob);
        sleep(1); // Slow down before submit
        driver.findElement(By.cssSelector("[type=submit]")).submit();

        sleep(2);
        String title = driver.getTitle();
        driver.quit();

        Assert.assertEquals(expectedTitle, title);
    }

    @Test
    public void testValidLogin() {
    	performLoginTest("Girish", "Girish_pass", "2004-05-11", "success");
    }

    @Test	
    public void testInvalidUsername() {
        performLoginTest("WrongUser", "Girish_pass", "05-11-2004", "fail");
    }

    @Test
    public void testInvalidPassword() {
        performLoginTest("Girish", "wrong_pass", "05-11-2004", "fail");
    }

    @Test
    public void testInvalidDOB() {
        performLoginTest("Girish", "Girish_pass", "01-01-2000", "fail");
    }

    @Test
    public void testEmptyFields() {
        performLoginTest("", "", "", "fail");
    }

    @Test
    public void testNullDOBFormat() {
        performLoginTest("Girish", "Girish_pass", "11-05-2004", "fail");
    }
}