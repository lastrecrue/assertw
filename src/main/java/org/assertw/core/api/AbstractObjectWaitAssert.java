package org.assertw.core.api;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * .
 * 
 * @author LAHMOURATE Achraf
 * 
 */
public abstract class AbstractObjectWaitAssert<S extends AbstractObjectWaitAssert<S>>
		extends AbstractWaitAssert<S, Callable<Object>, Object> {

	protected AbstractObjectWaitAssert(Callable<Object> actual, Class<?> selfType) {
		super(actual, selfType);
	}

	static final Logger logger = LogManager.getLogger(AbstractObjectWaitAssert.class.getName());

	private Object call;

	public S atMost(long timeout) {
		this.timeout = timeout;
		return myself;
	}

	public S pollInterval(long pollInterval, TimeUnit pollUnit) {
		this.pollInterval = pollInterval;
		this.pollUnit = pollUnit;
		return myself;
	}

	public void atMost(long timeout, TimeUnit unit) {
		this.timeout = timeout;
		this.unit = unit;
	}

	public S isEqualTo(final Object expected) {
		Runnable task = new Runnable() {

			@Override
			public void run() {
				while (!Thread.interrupted()) {
					call();
					if (call.equals(expected)) {
						return;
					}
					pool();
				}

			}

		};
		waitTest(expected, task);
		return myself;

	}

	@Override
	protected void call() {
		try {
			call = actual.call();
		} catch (Exception e) {
			logger.debug(e);
		}
	}

}
