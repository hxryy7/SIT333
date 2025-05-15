package sit707_week4;

/**
 * Demonstrates login behavior using various test inputs.
 */
public class Main {
    public static void main(String[] args) {
        testLogin(null, null);
        testLogin("", "Vardaan$1");
        testLogin("wrong", "Vardaan$1");
        testLogin("vardaanchahal2004@gmail.com", "");
        testLogin("vardaanchahal2004@gmail.com", "wrong");
        testLogin("vardaanchahal2004@gmail.com", "Vardaan$1");

        if (LoginForm.login("vardaanchahal2004@gmail.com", "Vardaan$1").isLoginSuccess()) {
            System.out.println("\tEmpty code >> " + LoginForm.validateCode(""));
            System.out.println("\tWrong code >> " + LoginForm.validateCode("000000"));
            System.out.println("\tCorrect code >> " + LoginForm.validateCode("123456"));
        }
    }

    private static void testLogin(String username, String password) {
        LoginStatus status = LoginForm.login(username, password);
        System.out.println("[" + username + ", " + password + "] >> " + status);
    }
}
