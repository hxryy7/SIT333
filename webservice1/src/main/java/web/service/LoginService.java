package web.service;

public class LoginService {

	public static boolean login(String username, String password, String dob) {
		return "ahsan".equals(username)
			&& "ahsan_pass".equals(password)
			&& "1990-01-01".equals(dob);
	}
}