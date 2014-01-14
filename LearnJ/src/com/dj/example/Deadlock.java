package com.dj.example;

public class Deadlock implements Runnable {

	A a = new A();
	B b = new B();

	Deadlock() {
		Thread.currentThread().setName("MainThread");
		Thread t = new Thread(this, "RacingThread");
		t.start();

		a.foo(b);
		System.out.println("Back in main thread");
	}

	public static void main(String[] args) {
		new Deadlock();

	}

	@Override
	public void run() {
		b.bar(a);
		System.out.println("Back in the Racing Thread");

	}

}

class A {
	synchronized void foo(B b) {
		String name = Thread.currentThread().getName();

		System.out.println(name + " entered A.foo()");

		try {
			Thread.sleep(1000);
		} catch (Exception ex) {
			System.out.println("A interrupted");
		}

		System.out.println(name + " trying to call B.last()");
		b.last();
	}

	synchronized void last() {
		System.out.println("Inside A.last");
	}
}

class B {
	synchronized void bar(A a) {
		String name = Thread.currentThread().getName();

		System.out.println(name + " entered B.bar()");

		try {
			Thread.sleep(1000);
		} catch (Exception ex) {
			System.out.println("B interrupted");
		}

		System.out.println(name + " trying to call A.last()");
		a.last();
	}

	synchronized void last() {
		System.out.println("Inside B.last");
	}
}
