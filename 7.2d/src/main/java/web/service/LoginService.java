package web.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LoginService {

    private static final String VALID_USERNAME = "Girish";
    private static final String VALID_PASSWORD = "Girish_pass";
    private static final String VALID_DOB = "2004-05-11";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");


    static {
        DATE_FORMAT.setLenient(false); // Strict date parsing
    }

    public static boolean login(String username, String password, String dob) {
        if (isNullOrEmpty(username) || isNullOrEmpty(password) || isNullOrEmpty(dob)) {
            System.out.println("[LoginService] Missing input fields.");
            return false;
        }

        if (!username.equalsIgnoreCase(VALID_USERNAME)) {
            System.out.println("[LoginService] Invalid username.");
            return false;
        }

        String formattedDob;
        try {
            formattedDob = DATE_FORMAT.format(DATE_FORMAT.parse(dob));
        } catch (ParseException e) {
            System.out.println("[LoginService] Invalid date format: " + dob);
            return false;
        }

        if (password.equals(VALID_PASSWORD) && formattedDob.equals(VALID_DOB)) {
            System.out.println("[LoginService] Login successful.");
            return true;
        } else {
            System.out.println("[LoginService] Invalid password or DOB.");
            return false;
        }
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}