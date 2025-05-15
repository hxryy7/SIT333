package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for LoginForm using decision table approach.
 */
public class LoginFormTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "224234094";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Harvardaan Chahal";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testEmptyUsernameAndPassword() {
        LoginStatus status = LoginForm.login("", "");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testEmptyUsernameValidPassword() {
        LoginStatus status = LoginForm.login("", "Vardaan$1");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testValidUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login("vardaanchahal2004@gmail.com", "");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testInvalidUsernameValidPassword() {
        LoginStatus status = LoginForm.login("wrong", "Vardaan$1");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testValidUsernameInvalidPassword() {
        LoginStatus status = LoginForm.login("vardaanchahal2004@gmail.com", "wrongpass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testValidUsernameAndPassword() {
        LoginStatus status = LoginForm.login("vardaanchahal2004@gmail.com", "Vardaan$1");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertEquals("123456", status.getErrorMsg());
    }

    @Test
    public void testValidUsernameValidPasswordEmptyCode() {
        LoginStatus status = LoginForm.login("vardaanchahal2004@gmail.com", "Vardaan$1");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertFalse(LoginForm.validateCode(""));
    }

    @Test
    public void testValidUsernameValidPasswordWrongCode() {
        LoginStatus status = LoginForm.login("vardaanchahal2004@gmail.com", "Vardaan$1");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertFalse(LoginForm.validateCode("000000"));
    }

    @Test
    public void testValidUsernameValidPasswordCorrectCode() {
        LoginStatus status = LoginForm.login("vardaanchahal2004@gmail.com", "Vardaan$1");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertTrue(LoginForm.validateCode("123456"));
    }
}