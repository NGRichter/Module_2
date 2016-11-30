package ss.week3.hotel;

import ss.week3.pw.*;

public class Password {
	public static final String INITIAL = "administrator";
	private String password;
	private Checker checker;
	private String factoryPassword;
	
	public Password() {
		checker = new BasicChecker();
		this.(checker);
	}
	
	public Password(Checker check) {
		
	}
	
	public boolean setWord(String oldpass, String newpass) {
		if (oldpass == password) {
			if (acceptable(newpass)) {
				password = newpass;			
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}
	
	public boolean testWord(String test) {
		if (test == password) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean acceptable(String suggestion) {
		if (suggestion.length() >= 6) {
			for (char c : suggestion.toCharArray()) {
				if (c == ' ') {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
}
