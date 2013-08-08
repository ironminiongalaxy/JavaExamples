package com.dj.example;

public class NewThread implements Runnable {
	String name;
	private volatile boolean running = true;
	int clickCount = 0;
	Thread t;

	NewThread(String threadName) {
		name = threadName;
		t = new Thread(this, name);
		System.out.println("Child Thread: " + t);
		t.start();
		System.out.println("After exiting Child Thread");
	}

	NewThread(int priority, String threadName) {
		name = threadName;
		t = new Thread(this, name);
		System.out.println("Child Thread: " + t.getName());
		t.start();
	}
	
	@Override
	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Child Thread: " + name + ": " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException ex) {
			System.out.println("Child Interrupted");
		}
		System.out.println("Exiting Child Thread " + name);

		while (running) {
			clickCount++;
		}
	}

	public void stop() {
		running = false;
	}
}
