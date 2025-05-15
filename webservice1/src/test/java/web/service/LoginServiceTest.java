package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoginServiceTest {

    // Scenario: all credentials correct
    @Test
    public void shouldAuthenticateWithValidCredentials() {
        assertTrue(LoginService.login("vardaan chahal", "vardaan chahal", "2004-09-11"));
    }

    // Scenario: wrong username only
    @Test
    public void shouldRejectInvalidUsername() {
        assertFalse(LoginService.login("invalidUser", "vardaan chahal", "2004-09-11"));
    }

    // Scenario: wrong password only
    @Test
    public void shouldRejectInvalidPassword() {
        assertFalse(LoginService.login("vardaan chahal", "wrongpass", "2004-09-11"));
    }

    // Scenario: wrong date of birth only
    @Test
    public void shouldRejectIncorrectDob() {
        assertFalse(LoginService.login("vardaan chahal", "vardaan chahal", "1999-12-31"));
    }

    // Scenario: all fields invalid
    @Test
    public void shouldRejectWhenAllFieldsInvalid() {
        assertFalse(LoginService.login("invalid", "invalid", "2022-12-12"));
    }

    // Scenario: null username
    @Test
    public void shouldRejectNullUsername() {
        assertFalse(LoginService.login(null, "vardaan chahal", "2004-09-11"));
    }

    // Scenario: null password
    @Test
    public void shouldRejectNullPassword() {
        assertFalse(LoginService.login("vardaan chahal", null, "2004-09-11"));
    }

    // Scenario: null date of birth
    @Test
    public void shouldRejectNullDob() {
        assertFalse(LoginService.login("vardaan chahal", "vardaan chahal", null));
    }

    // Scenario: empty strings for all fields
    @Test
    public void shouldRejectEmptyStrings() {
        assertFalse(LoginService.login("", "", ""));
    }

    // Scenario: whitespace-only input
    @Test
    public void shouldRejectWhitespaceOnlyInput() {
        assertFalse(LoginService.login(" ", " ", " "));
    }

    // Scenario: unsupported DOB format
    @Test
    public void shouldRejectUnsupportedDobFormat() {
        assertFalse(LoginService.login("vardaan chahal", "vardaan chahal", "25-04-2004"));
    }
}
