package ss.week6;

import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("What is your name? ");
			String next = scan.nextLine();
			if (next.isEmpty()) {
				break;
			} else {
				System.out.println("Hello " + next);
			}
		}
		scan.close();
		
	}
}
