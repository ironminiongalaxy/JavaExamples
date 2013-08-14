package com.dj.example;

public class ThreadCommunication {
	public static void main(String args[]) {
		Q q = new Q();
		new Consumer(q);
		new Producer(q);
		
		
		System.out.println("Cancel Ctrl+c");
	}
}

class Q {
	int n;
	boolean valSet;

	synchronized int get() {
		if(!valSet)
			try {
				wait();
			} catch(InterruptedException ex) {
				System.out.println("Caught Interrupted");
			}
		System.out.println("Get: " + n);
		valSet = false;
		notify();
		return n;
	}

	synchronized void put(int n) throws InterruptedException {
		if(valSet)
			try {
				wait();
			} catch(InterruptedException ex) {
				System.out.println("Caught Interrupted");
			}		
		this.n = n;
		valSet = true;
		System.out.println("Put: " + n);
		if(n==10) {
			Thread.sleep(1000);
		}
		notify();
	}
}

class Producer implements Runnable {
	Q q;

	Producer(Q q) {
		this.q = q;
		new Thread(this, "Producer").start();
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			try {
				q.put(i++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	Q q;

	Consumer(Q q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}

	@Override
	public void run() {
		while (true) {
			q.get();
		}
	}
}