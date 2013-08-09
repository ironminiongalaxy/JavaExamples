package com.dj.example;

public class Synch {
	public static void main(String args[]) {
		SyncCallMe target = new SyncCallMe();
		Caller c1 = new Caller(target, "Hello");
		Caller c2 = new Caller(target, "Synced");
		Caller c3 = new Caller(target, "World");
		
		try {
			c1.t.join();
			c2.t.join();
			c3.t.join();
		} catch (InterruptedException ex) {
			System.out.println("Interrupted main");
		}
	}
}
