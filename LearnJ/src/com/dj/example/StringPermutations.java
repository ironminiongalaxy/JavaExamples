package com.dj.example;

public class StringPermutations {

	private static final String MY_WORD = "abcd";

	public static void main(String[] args) {
		// permutation(MY_WORD);
		for (int i = 0; i <= MY_WORD.length(); i++)
			getSubStrings(MY_WORD.substring(i));
	}

	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1, n));
		}
	}

	public static void getSubStrings(String word) {
		if (word.length() == 1) {
			System.out.println(word);
			return;
		}

		if (word.length() != 0) {
			System.out.println(word);
			getSubStrings(word.substring(0, word.length() - 1));
		}
	}

}
