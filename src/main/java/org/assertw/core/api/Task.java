package org.assertw.core.api;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	private Callable<?> actual;
	private Object expected;
	private long pollInterval;
	private TimeUnit pollUnit;

	private Object call;

	public Task(Callable<?> actual, Object expected) {
		super();
		this.actual = actual;
		this.expected = expected;
	}

	public Task(Callable<?> actual, Object expected, long pollInterval, TimeUnit pollUnit) {
		super();
		this.actual = actual;
		this.expected = expected;
		this.pollInterval = pollInterval;
		this.pollUnit = pollUnit;
	}

	@Override
	public void run() {
		while (!Thread.interrupted()) {

			try {
				call = actual.call();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (call.equals(expected)) {
				return;
			}
			try {
				Thread.sleep(pollUnit.toMillis(pollInterval));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public Object getCall() {
		return call;
	}

}
