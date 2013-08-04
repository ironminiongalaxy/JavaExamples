package com.dj.example.utils;

public class CustException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int detail; 
	public CustException(int i) {
		detail = i;
	}
	
	public String toString() {
		return "Custom Exception[" + detail + "]";
	}
}
