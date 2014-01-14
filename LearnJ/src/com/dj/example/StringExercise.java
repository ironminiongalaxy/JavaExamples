package com.dj.example;

public class StringExercise {
	private static char[] str = { 'a', 's' , 's', 's', 'b' ,'c' };
	public static void main(String args[]) {
		removeDuplicates(str);
	}

	

	
	public static void removeDuplicates(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;

		int tail = 1;

		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
		for (int i = 0; str[i] != 0; i++) {
			System.out.println(str[i]);
		}
	}

}
