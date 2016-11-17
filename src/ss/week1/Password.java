package ss.week1;

public class Password {
	public static final String INITIAL = "administrator";
	private String password;
	
	public Password() {
		password = INITIAL;
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
