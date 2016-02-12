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
import org.assertj.core.api.AbstractAssert;

public abstract class AbstractWaitAssert<S extends AbstractWaitAssert<S, A, T>, A extends Callable<T>, T>
		extends AbstractAssert<S, A> {

	protected T call;

	static final Logger logger = LogManager.getLogger(AbstractWaitAssert.class.getName());

	protected long timeout = 5;
	protected TimeUnit unit = TimeUnit.SECONDS;

	protected long pollInterval = 1;
	protected TimeUnit pollUnit = TimeUnit.SECONDS;

	private final ExecutorService executor = Executors.newFixedThreadPool(1);

	protected AbstractWaitAssert(A actual, Class<?> selfType) {
		super(actual, selfType);
	}

	protected void pool() {
		try {
			Thread.sleep(pollUnit.toMillis(pollInterval));
		} catch (InterruptedException e) {
			logger.debug(e);
		}
	}

	protected void waitTest(final Object expected, Runnable task) {
		Future<?> future = executor.submit(task);
		try {
			future.get(timeout, unit);
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e.getMessage());
		} catch (TimeoutException e) {
			throw new RuntimeException(String.format("timeout after %d %s : expected is <%s> but actuel is <%s>",
					timeout, unit.toString().toLowerCase(), expected, call));
		}
	}

	abstract void call();

}
