package org.assertw.core.api;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class TaskObjects implements Runnable {
	static final Logger logger = LogManager.getLogger(AbstractObjectWaitAssert.class.getName());

	private Callable<Collection<?>> actual;
	private Collection<?> expected;
	private long pollInterval;
	private TimeUnit pollUnit;

	private Collection<?> call;

	public TaskObjects(Callable<Collection<?>> actual, Collection<?> expected) {
		super();
		this.actual = actual;
		this.expected = expected;
	}

	public TaskObjects(Callable<Collection<?>> actual, Collection<?> expected, long pollInterval, TimeUnit pollUnit) {
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
			if (call.containsAll(expected)) {
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
