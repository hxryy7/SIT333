package sit707_week4;

/**
 * Authenticates user based on username and password.
 */
public class LoginForm {
    private static String USERNAME = "vardaanchahal2004@gmail.com";
    private static String PASSWORD = "Vardaan$1";
    private static String VALIDATION_CODE = "123456";

    public static LoginStatus login(String username, String password) {
        if (username == null || username.isEmpty())
            return new LoginStatus(false, "Empty Username");

        if (password == null || password.isEmpty())
            return new LoginStatus(false, "Empty Password");

        if (!username.equals(USERNAME))
            return new LoginStatus(false, "Credential mismatch");

        if (!password.equals(PASSWORD))
            return new LoginStatus(false, "Credential mismatch");

        return new LoginStatus(true, VALIDATION_CODE);
    }

    public static boolean validateCode(String code) {
        if (code == null || code.isEmpty() || !code.equals(VALIDATION_CODE))
            return false;
        return true;
    }
}