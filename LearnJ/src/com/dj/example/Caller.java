package com.dj.example;

public class Caller implements Runnable {

	String msg;
	SyncCallMe target;
	Thread t;

	Caller(SyncCallMe target, String msg) {
		this.target = target;
		this.msg = msg;
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		// Can call target.call(msg) where call() has the keyword synchronized
		synchronized (target) {
			target.call(msg);
		}
	}

}
