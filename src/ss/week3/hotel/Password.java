package ss.week3.hotel;

import ss.week3.pw.*;

public class Password {
	public static final String INITIAL = "administrator";
	private String password;
	private static Checker checker = new BasicChecker();
	private Checker bchecker;
	public String factoryPassword;
		

	public Password(Checker check) {
		this.bchecker = check;
		this.factoryPassword = BasicChecker.INITPASS;
	}
	
	public Password() {
		this(checker);		


	}
		
	public boolean setWord(String oldpass, String newpass) {
		if (oldpass.equals(factoryPassword) && acceptable(newpass)) {
			factoryPassword = newpass;			
			return true;
		} else {
			return false;
		}
	}
	
	public boolean testWord(String test) {
		return test.equals(factoryPassword);
	}
	
	public boolean acceptable(String suggestion) {
		return checker.acceptable(suggestion);
	}
}
