package org.assertw.core.api;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TaskObject implements Runnable {

	static final Logger logger = LogManager.getLogger(AbstractObjectWaitAssert.class.getName());

	private Callable<?> actual;
	private Object expected;
	private long pollInterval;
	private TimeUnit pollUnit;

	private Object call;

	public TaskObject(Callable<?> actual, Object expected) {
		super();
		this.actual = actual;
		this.expected = expected;
	}

	public TaskObject(Callable<?> actual, Object expected, long pollInterval, TimeUnit pollUnit) {
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
				logger.debug(e);
			}
			if (call.equals(expected)) {
				return;
			}
			try {
				Thread.sleep(pollUnit.toMillis(pollInterval));
			} catch (InterruptedException e) {
				logger.debug(e);
			}
		}

	}

	public Object getCall() {
		return call;
	}

}
