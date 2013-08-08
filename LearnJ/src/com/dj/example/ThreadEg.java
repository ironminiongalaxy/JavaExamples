package com.dj.example;

public class ThreadEg {

	public static void main(String[] args) {

		new NewThread();
		Thread t = Thread.currentThread();
		System.out.println("Current Thread Name : " + t.getName());
		System.out.println("Current Thread: " + t);
		t.setName("My Thread");
		System.out.println("New Thread Name: " + t);

		try {
			for (int n = 5; n > 0; n--) {
				System.out.println("Main Thread: " + n);
				// Ideally the main thread should finish last - so, give it a
				// time out larger than other threads
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Main Thread Interrupted");
			e.printStackTrace();
		}
		System.out.println("Main Thread complete");
	}

}
