package com.dj.example;

public class TryCatch {
	private static int d = 1, a, test[] = { 1 };

	public static void main(String[] args) {

		try {
			System.out.println("Inside Outer Try block");
			a = 42 / d;
			System.out.println("Outer Try block : should be printed");
			divByZero();

		} catch (Exception e) {
			System.out.println("This an Exception in Outer Nest:");
			//This will catch as Arithmetic when d=0 and OutOfBounds when d=3
			e.printStackTrace();
		}
		System.out.println("After the exception");
	}

	private static void divByZero() {
		try {
			if (d == 1) {
				System.out.println("Inside Inner Try block");
				d = d / (0);
			}
			if (d == 3) {
				int c[] = { 2 };
				System.out.println("Inside Inner Try block");
				c[5] = 100;
				System.out.println("Inner Try block : should NOT be printed");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("This is an Exception in method:");
			throw e;
		}
	}

}
