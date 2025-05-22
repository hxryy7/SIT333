package web.service;

import org.junit.Assert;
import org.junit.Test;

public class RegistrationServiceUnitTest {

    // Test for valid registration input
    @Test
    public void testValidRegistration() {
        boolean result = RegistrationService.register("Girish", "Sirpali", "girish@gmail.com", "2004-05-11");
        Assert.assertTrue("Registration should succeed with valid input", result);
    }

    // Test for missing first name
    @Test
    public void testMissingFirstName() {
        boolean result = RegistrationService.register("", "Sirpali", "girish@gmail.com", "2004-05-11");
        Assert.assertFalse("Registration should fail with missing first name", result);
    }

    // Test for missing last name
    @Test
    public void testMissingLastName() {
        boolean result = RegistrationService.register("Girish", "", "girish@gmail.com", "2004-05-11");
        Assert.assertFalse("Registration should fail with missing last name", result);
    }

    // Test for missing email
    @Test
    public void testMissingEmail() {
        boolean result = RegistrationService.register("Girish", "Sirpali", "", "2004-05-11");
        Assert.assertFalse("Registration should fail with missing email", result);
    }

    // Test for invalid email format
    @Test
    public void testInvalidEmailFormat() {
        boolean result = RegistrationService.register("Girish", "Sirpali", "invalid-email", "2004-05-11");
        Assert.assertFalse("Registration should fail with invalid email format", result);
    }

    // Test for missing date of birth
    @Test
    public void testMissingDOB() {
        boolean result = RegistrationService.register("Girish", "Sirpali", "girish@gmail.com", "");
        Assert.assertFalse("Registration should fail with missing date of birth", result);
    }

    // Test for invalid date format (incorrect date format)
    @Test
    public void testInvalidDOBFormat() {
        boolean result = RegistrationService.register("Girish", "Sirpali", "girish@gmail.com", "11-05-2004");
        Assert.assertFalse("Registration should fail with invalid date format", result);
    }

    // Test for valid minimal input
    @Test
    public void testMinimalValidInput() {
        boolean result = RegistrationService.register("A", "B", "a@b.co", "2000-01-01");
        Assert.assertTrue("Registration should succeed with minimal valid input", result);
    }

    // Test for invalid first name (containing digits)
    @Test
    public void testInvalidFirstName() {
        boolean result = RegistrationService.register("G1rish", "Sirpali", "girish@gmail.com", "2004-05-11");
        Assert.assertFalse("Registration should fail with invalid first name containing digits", result);
    }

    // Test for invalid last name (containing special characters)
    @Test
    public void testInvalidLastName() {
        boolean result = RegistrationService.register("Girish", "Sirp@li", "girish@gmail.com", "2004-05-11");
        Assert.assertFalse("Registration should fail with invalid last name containing special characters", result);
    }
}