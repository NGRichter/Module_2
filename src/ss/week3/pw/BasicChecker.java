package ss.week3.pw;

import java.util.Random;

public class BasicChecker implements Checker {

	public BasicChecker() {
		// TODO Auto-generated constructor stub
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
		for (int o = 1; o <= i; i++) {
			
		}
		return null;
	}

}
