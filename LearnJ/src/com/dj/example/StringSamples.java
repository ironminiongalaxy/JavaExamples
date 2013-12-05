package com.dj.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class StringSamples {
	private static final String TEST_STRING = "this is best best is test west is rest test is best but rest is test which is best test";

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException {
		int[] a = { 1, 2, 3 };
		a = prodofArray(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

		System.out.println("------------------------------");
		for (int i : reflection())
			System.out.println(i);
		System.out.println("------------------------------");

		System.out.println("12434");
		System.out.println(allUnique(null));
		HashMap<String, Integer> map = countStrings(TEST_STRING);
		for (String word : map.keySet())
			System.out.println(word + " appears: " + map.get(word));

	}

	/**
	 * Check if the word has all unique characters
	 * 
	 * @param word
	 * @return whether the string has all unique characters
	 */
	public static boolean allUnique(String word) {
		try {
			if (word.length() <= 0)
				return true;
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < word.length(); i++) {
				if (map.containsKey(word.charAt(i)))
					return false;
				else
					map.put(word.charAt(i), i);
			}

		} catch (NullPointerException e) {
			System.out.println("NULL string entered. False will be returned");
			return false;
		}
		return true;
	}

	private static HashMap<String, Integer> countStrings(String sentence) {
		if (sentence.length() <= 0) {
			return null;
		}
		int count;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String word : sentence.split(" ")) {

			if (map.containsKey(word)) {
				// System.out.println("Map contains: " + word + ". Adding" );
				count = map.get(word);
				map.put(word, ++count);
			}

			else {
				count = 0;
				// System.out.println("Map contains: " + word + ". Adding" );
				map.put(word, ++count);
			}
		}
		return map;
	}

	private static int[] reflection() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException {
		Class cls = Class.forName("com.dj.example.Sorting");
		Object obj = cls.newInstance();
		int[] a = new int[] { 1, 2, 43, 56, 3, 5, 1 };

		Method sort = cls.getMethod("qSort", new Class[] { int[].class });
		Character b = 'b';
		return (int[]) sort.invoke(obj, a);
	}

	private static int[] prodofArray(int[] a) {
		int[] prod = new int[a.length];
		int[] prodLower = new int[a.length];
		int[] prodUpper = new int[a.length];

		int p = 1;
		for (int i = 0; i < a.length; i++) {
			prodLower[i] = p;
			p *= a[i];
		}

		p = 1;
		for (int i = (a.length - 1); i >= 0; i--) {
			prodUpper[i] = p;
			p *= a[i];
		}

		for (int i = 0; i < a.length; i++)
			prod[i] = prodLower[i] * prodUpper[i];
		return prod;
	}

	private static boolean isSubstring(String a, String b) {
		if (a.length() == 0 || b.length() == 0 || b.length() > a.length())
			return false;
		int i = 0;
		while (i < a.length()) {
			int j = 0;
			while (j < b.length()) {
				int matchCount = 0;
				if (b.charAt(j) == a.charAt(i)) {
					j++;
					i++;
					matchCount++;
					continue;
				}

			}
			i++;
		}

		return false;
	}
}
