package com.dj.example;

public class NewThread extends Thread {

	NewThread() {
		t = new Thread(this, "New Thread");
		System.out.println("Child Thread: " + t);
		t.start();
		System.out.println("After exiting Child Thread");
	}

	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Child Thread: " + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException ex) {
			System.out.println("Child Interrupted");
		}
		System.out.println("Exiting Child Thread");
	}

}
