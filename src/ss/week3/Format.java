package ss.week3;

public class Format {

	public static void main(String[] args) {
		double safe = -20.20;
		double a = 205.1;
		double b = 0;
		System.out.println(printLine("Safe", safe));
		System.out.println(printLine("Abracafuckyou", a));
		System.out.println(printLine("Test", b));
	}
	public static String printLine(String text, double amount) {
		String print = String.format("%-20s %10.2f€", text, amount);
		return print;
	}
}
