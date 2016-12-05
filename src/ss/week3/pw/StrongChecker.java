package ss.week3.pw;

import java.util.Random;

public class StrongChecker extends BasicChecker {
	
	
	@Override
	public boolean acceptable(String word) {
		if (word.length() >= 6) {
			int i = 0;
			for (char e : word.toCharArray()) {
				if (i == 0) {
					if (!((e >= 'a' && e <= 'z') || (e >= 'A' && e <= 'Z'))) {
						return false;
					}
					
				}
				if (i == (word.length() - 1)) {
					if (!(e >= '0' && e <= '9')) {
						return false;
					}
				}
				if (e == ' ') {
					return false;
				}
				i++;
			}
		}
		return true;
	}
	
	@Override
	public String generatePassword() {
		Random rand = new Random();
		int i = rand.nextInt(14) + 6;
		char[] passwords = new char[21];
		for (int o = 1; o < i; o++) {
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
		int first = rand.nextInt(26) + 65;
		passwords[0] = (char) first;
		int last = rand.nextInt(10) + 48;
		passwords[i] = (char) last;
		String pass = new String(passwords);
		return pass;
	}
}
