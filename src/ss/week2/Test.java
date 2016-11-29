package ss.week2;

public class Test {
	public static String one = "Hallo";
	public static String two = "Hallo";
	public static void main(String[] args) {
		if (one == new String("Hallo")) {
			System.out.println("They are the same");
			
		} else {
			System.out.println("They are not the same");
		}
		
		if (one.equals(new String("Hallo"))) {
			System.out.println("They are the same");
			
		} else {
			System.out.println("They are not the same");
		}
	}

}
