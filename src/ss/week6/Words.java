package ss.week6;

import java.util.Scanner;

public class Words {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			String next = in.next();
			if (next == "end") {
				break;
			} else {
				System.out.println(next);
			}
		}
		in.close();
	}
}
