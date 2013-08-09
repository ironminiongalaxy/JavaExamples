package com.dj.example;

public class SyncCallMe {
	// Can have synchronized keyword before void. Or the object of this class
	// can be synchronized(object){methods;}
	void call(String msg) {
		System.out.println("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			System.out.println("Interrupted");
		}
		System.out.println("]");
	}
}
