package web.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginSeviceUnitTest {

    @Test
    public void testValidCredentials() {
        assertTrue(LoginService.login("Girish", "Girish_pass", "2004-05-11"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(LoginService.login("user123", "Girish_pass", "05-11-2004"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(LoginService.login("Girish", "pass123", "05-11-2004"));
    }

    @Test
    public void testInvalidDob() {
        assertFalse(LoginService.login("Girish", "Girish_pass", "15-01-2004"));
    }

    @Test
    public void testNullValues() {
        assertFalse(LoginService.login(null, null, null));
    }

    @Test
    public void testEmptyValues() {
        assertFalse(LoginService.login("", "", ""));
    }

    @Test
    public void testBoundaryDobFormat() {
        assertFalse(LoginService.login("Girish", "Girish_pass", "5-11-2004")); // non-ISO format
    }
}