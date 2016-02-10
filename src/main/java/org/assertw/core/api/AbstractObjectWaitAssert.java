package org.assertw.core.api;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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

	protected long timeout = 5;
	protected TimeUnit unit = TimeUnit.SECONDS;

	protected long pollInterval = 1;
	protected TimeUnit pollUnit = TimeUnit.SECONDS;

	private Object call;

	private final ExecutorService executor = Executors.newFixedThreadPool(1);

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
		// TaskObject task = new TaskObject(actual, expected, pollInterval,
		// pollUnit);
		Runnable task = new Runnable() {

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

		};
		Future<?> future = executor.submit(task);
		try {
			future.get(timeout, unit);
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e.getMessage());
		} catch (TimeoutException e) {
			throw new RuntimeException(String.format("timeout after %d %s : expected is <%s> but actuel is <%s>",
					timeout, unit.toString().toLowerCase(), expected, call));
		}
		return myself;

	}

}
