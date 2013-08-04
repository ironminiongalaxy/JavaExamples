package com.dj.example.utils;

public class CustException extends Exception {
	int detail; 
	public CustException(int i) {
		detail = i;
	}
	
	@Override
	public String toString() {
		return "Custom Exception[" + detail + "]";
	}
}
