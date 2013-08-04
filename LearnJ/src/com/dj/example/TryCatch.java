package com.dj.example;

import java.util.Random;

import com.dj.example.utils.CustException;

/**
 * Examples to the Try Catch blocks; Nested Class; Examples for Exceptions
 * 
 * @author digvijay
 * 
 */
public class TryCatch {
	private static int d = 4, a, test[] = { 1 };

	public static void main(String[] args) {

		try {
			System.out.println("Inside Outer Try block");
			// e.initCause() and e.getCause() example
			a = 42 / returnRandNumber(10);
			System.out.println("Outer Try block : should be printed");
			divByZero();
		} catch (Exception e) {
			System.out.println("This an Exception in Outer Nest:");
			// This will catch as Arithmetic when d=0 and OutOfBounds when d=3
			e.getCause().printStackTrace();
		}
		System.out.println("After the exception");
	}

	private static void divByZero() {
		try {
			System.out.println("Inside Inner Try block");
			if (d == 1) {
				d = d / (0);
			}
			if (d == 3) {
				int c[] = { 2 };
				c[5] = 100;
				System.out.println("Inner Try block : should NOT be printed");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("This is an Exception in method:");
			throw e;
		} finally {
			System.out.println("Inside Finally");
		}
	}

	private static int returnRandNumber(int i) {
		try {
			int x = new Random().nextInt(i);
			System.out.println("x: " + x);
			int y = 5 / x;
			return x;
		} catch (ArithmeticException e) {
			e.initCause(new CustException(0));
			throw e;
		}
	}
}
