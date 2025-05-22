package web.service;

import java.util.regex.Pattern;

public class RegistrationService {

    // Method to register a user
    public static boolean register(String firstName, String lastName, String email, String dob) {
        if (isNullOrEmpty(firstName) || isNullOrEmpty(lastName) || isNullOrEmpty(email) || isNullOrEmpty(dob)) {
            System.out.println("Error: One or more fields are empty.");
            return false;
        }

        // Validate name (no digits, no special characters)
        if (!isValidName(firstName) || !isValidName(lastName)) {
            System.out.println("Error: Invalid name format.");
            return false;
        }

        // Validate email format
        if (!isValidEmail(email)) {
            System.out.println("Error: Invalid email format.");
            return false;
        }

        // Validate Date of Birth (in format yyyy-MM-dd)
        if (!isValidDateOfBirth(dob)) {
            System.out.println("Error: Invalid date of birth.");
            return false;
        }

        return true;
    }

    private static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    private static boolean isValidName(String name) {
        return name != null && !name.matches(".*\\d.*") && !name.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private static boolean isValidDateOfBirth(String dob) {
        try {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            sdf.parse(dob);
        } catch (java.text.ParseException e) {
            return false;
        }

        String[] dateParts = dob.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);

        java.util.Calendar dobCalendar = java.util.Calendar.getInstance();
        java.util.Calendar currentCalendar = java.util.Calendar.getInstance();
        dobCalendar.set(year, month - 1, day);

        return !dobCalendar.after(currentCalendar);
    }
}