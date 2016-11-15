package com.connected3d.test;

import java.util.Scanner;

public class Main {
		
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {		

		runcode();

	}
	
	public static void runcode() {
		System.out.println("I run correctly");
		System.out.println("Because A + B = C");
		int a = askInteger("A = ");
		int b = askInteger("B = ");
		int c = a + b;
		System.out.println("C equals " + c);
		a = a * a;
		System.out.println("And A squared equals " + a);
		System.out.println(askString("Say something that will be said by the console: "));
		System.out.println(askString("Say something that will be said by the console: "));
	}
	public static int askInteger(String str) {
		System.out.print(str);
		while (!scan.hasNextInt()) {
			System.out.print("Please enter an integer: ");			
			scan.next();
		}	
		int iinput = scan.nextInt();
		scan.nextLine();
		return iinput;
	}
	public static String askString(String str) {
		System.out.print(str);
		String sinput = scan.nextLine();
		return sinput;
	}

}
