package com.dj.example;

public class ThreadEg {

	/**
	 * Thread Examples
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		NewThread t1 = new NewThread("Thread1");
		// Priority: 1-10 Norm: 5
		t1.t.setPriority(Thread.NORM_PRIORITY);
		NewThread t2 = new NewThread("Thread2");
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		NewThread t3 = new NewThread(Thread.NORM_PRIORITY - 4, "Thread3");
		NewThread t4 = new NewThread(Thread.NORM_PRIORITY + 4, "Thread4");
		t1.t.setPriority(Thread.MIN_PRIORITY);
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

		// Set a thread to wait to let other threads run
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Main Thread Interrupted");
			e.printStackTrace();
		}

		// Set runnable on all threads to False
		t1.stop();
		t2.stop();
		t3.stop();
		t4.stop();

		// Wait for all threads to finish
		try {
			t1.t.join();
			t2.t.join();
			t3.t.join();
			t4.t.join();
		} catch (InterruptedException ex) {
			System.out.println("Unable to stop Threads");
		}

		System.out.println("Thread 1 status: " + t1.t.isAlive());
		System.out.println("Thread 2 status: " + t2.t.isAlive());

		// Thread4 has Higher priority (lower number) - so it should have more
		// clicks on a single processor - may differ here.
		System.out.println("Thread 3 Clicks#: " + t3.clickCount);
		System.out.println("Thread 4 Clicks#: " + t4.clickCount);

		System.out.println("Main Thread complete");
	}

}
