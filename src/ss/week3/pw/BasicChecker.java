package ss.week3.pw;

import java.util.Random;

public class BasicChecker implements Checker {
	
	public static final String INITPASS = "Bitgroup105";
	
	public static void main(String[] args) {
		BasicChecker checker = new BasicChecker();
		System.out.println(checker.generatePassword());
		StrongChecker schecker = new StrongChecker();
		System.out.println(schecker.generatePassword());
	}
	
	public BasicChecker() {
	}
	
	@Override
	public boolean acceptable(String word) {
		if (word.length() >= 6) {
			for (char e : word.toCharArray()) {
				if (e == ' ') {
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public String generatePassword() {
		Random rand = new Random();
		int i = rand.nextInt(14) + 6;
		char[] passwords = new char[21];
		for (int o = 0; o <= i; o++) {
			int n = rand.nextInt(62);
			if (n >= 0 && n <= 25) {
				passwords[o] = (char) (65 + n);
			}
			if (n >= 26 && n <= 51) {
				passwords[o] = (char) (71 + n);
			}
			if (n >= 52 && n <= 61) {
				passwords[o] = (char) (-4 + n);
			}
			
		}
		String pass = new String(passwords);
		return pass;
	}

}
