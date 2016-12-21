package ss.week6;

import java.util.Scanner;

public class Words {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.print("Line (or 'end'): ");
			int i = 1;
			String sentence = in.nextLine();
			String[] words = sentence.split(" ");
			if (sentence.startsWith("end")) {
				break;
			} else {
				for (String string : words) {
					System.out.println("Word " + i + ": " + string);
					i++;
				}
			}
		}
		in.close();
	}
}
