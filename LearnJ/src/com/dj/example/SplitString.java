package com.dj.example;

public class SplitString {

	private static final String HELLO_STRING = "Hello world. From Compilr!com";

	/**
	 * This is the main entry point for the application
	 */
	public static void main(String args[]) {
		System.out.println(HELLO_STRING);
		String[] words = HELLO_STRING.split(" ");
		for (String i : words) {
			boolean smallerWordPresent = false;
			if (i.contains("!")) {
				smallerWordPresent = true;
				for (String smallerWord : i.split("!")) {
					System.out.println(smallerWord);
				}
			}
			if (i.contains(".")) {
				smallerWordPresent = true;
				System.out.println(i);
				for (String smallerWord : i.split(".")) {
					System.out.println(smallerWord);
				}
			}
			if (!smallerWordPresent)
				System.out.println(i);
		}
	}

}
