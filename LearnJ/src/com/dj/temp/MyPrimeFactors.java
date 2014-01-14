package com.dj.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyPrimeFactors {
	static int num = 90;
	private static Map<Integer, ArrayList<Integer>> factorsMap = new HashMap<Integer, ArrayList<Integer>>();
	public static void main(String[] args) {
		for(int i: allFactors(num)) {
			System.out.print(i + " ");
		}
		
		for(int i : factorsMap.keySet()) {
			System.out.println("");
			System.out.print(i + ": " + factorsMap.get(i));
		}
	}
	
	
	
	public static ArrayList<Integer> allFactors(int number) {
		int n = number;
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				if(!factorsMap.containsKey(i)) 
					factorsMap.put(i, allFactors(i));
				if (!factors.contains(i)) {
					factors.add(i);
					
				}
//				n /= i;
			}
		}
		return factors;
	}

}
