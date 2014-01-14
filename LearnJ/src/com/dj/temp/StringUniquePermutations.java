package com.dj.example;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author digvijay
 * 
 */
public class StringUniquePermutations {
	private static HashMap<String, Integer> map = new HashMap<String, Integer>();

	public static void main(String args[]) throws Exception {
		String word = new String();
		Scanner in = new Scanner(System.in);
		try {
			word = in.nextLine();
		} catch (Exception e) {
			System.out.println("Unable to read STDIN");
		}

		if (word.length() == 0) {
//			System.out.println(0);
		}
		for (int i = 0; i < word.length(); i++) {
			word = word.substring(i);
			if (word != null && word.length() != 0)
				getSubStrings(word);
		}
		System.out.println(map.size());
	
		
	}

	/**
	 * Writes all unique substrings in a hashmap.
	 * 
	 * @param word
	 *            to find substrings
	 * @return HashMap of all unique substrings
	 */
	private static HashMap<String, Integer> getSubStrings(String word) {
		if (word.length() == 1) {
			addWordsToMap(word);
		}
		if (word.length() != 0) {
			addWordsToMap(word);
			getSubStrings(word.substring(0, word.length() - 1));
		}
		return map;
	}

	private static void addWordsToMap(String word) {
		System.out.println(word);
		int countOccurance = 0;
		if (map.containsKey(word)) {
			countOccurance = map.get(word);
			countOccurance += 1;
		}
		map.put(word, countOccurance+=1);
	}
}