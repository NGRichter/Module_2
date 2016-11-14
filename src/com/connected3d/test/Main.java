package com.connected3d.test;

import java.util.Scanner;

public class Main {

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
	}
	public static int askInteger(String str) {
		Scanner scan = new Scanner(System.in);
		System.out.println(str);
		while (!scan.hasNextInt()) {
			System.out.print("Please enter an interger: ");			
			scan.next();
		}	
		int input = scan.nextInt();
		return input;
	}

}
