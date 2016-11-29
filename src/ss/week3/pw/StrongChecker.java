package ss.week3.pw;

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
			}
		}
		return true;
	}
}
