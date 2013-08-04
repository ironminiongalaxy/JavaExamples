package com.dj.example;

public class TryCatch {

	public static void main(String[] args) {
		int d, a, test[] = { 1 };
		try {
			d = 3;
			System.out.println("Inside Outer Try block");
			a = 42 / d;
			System.out.println("Outer Try block : should be printed");
			try {
				if (d == 1) {
					System.out.println("Inside Inner Try block");
					d = d / (0);
				}
				if (d == 3) {
					int c[] = { 2 };
					System.out.println("Inside Inner Try block");
					c[5] = 100;
					System.out
							.println("Inner Try block : should NOT be printed");
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("This is an OutOfBounds in Exception:");
				e.printStackTrace();
			}
		} catch (ArithmeticException e) {
			System.out.println("This an Arithmetic Exception:");
			e.printStackTrace();
		}
		System.out.println("After the exception");
	}

}
