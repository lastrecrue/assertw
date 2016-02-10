package org.assertw.core.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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
import org.assertj.core.api.Assertions;
import org.assertj.core.internal.ObjectArrays;

/**
 * .
 * 
 * @author LAHMOURATE Achraf
 * 
 */
public abstract class AbstractObjectsWaitAssert<S extends AbstractObjectsWaitAssert<S>>
		extends AbstractWaitAssert<S, Callable<Collection<?>>, Collection<?>> {

	static final Logger logger = LogManager.getLogger(AbstractObjectsWaitAssert.class.getName());

	protected long timeout = 5;
	protected TimeUnit unit = TimeUnit.SECONDS;

	protected long pollInterval = 1;
	protected TimeUnit pollUnit = TimeUnit.SECONDS;

	private final ExecutorService executor = Executors.newFixedThreadPool(1);

	protected AbstractObjectsWaitAssert(Callable<Collection<?>> actual, Class<?> selfType) {
		super(actual, selfType);
	}

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

	public S contains(Object... expected) {

		List<Object> expectedAsList = Arrays.asList(expected);
		Runnable task = new Runnable() {

			@Override
			public void run() {
				while (!Thread.interrupted()) {

					call();
					if (call.containsAll(expectedAsList)) {
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
					timeout, unit.toString().toLowerCase(), call, expectedAsList));
		}
		return myself;
	}

	public S containsOnly(Object... expected) {
		List<Object> expectedAsList = Arrays.asList(expected);
		Runnable task = new Runnable() {

			@Override
			public void run() {
				while (!Thread.interrupted()) {

					call();
					boolean out = true;
					for (Object object : call) {
						if (!expectedAsList.contains(object)) {
							out = false;
							break;
						}
					}
					if (out) {
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
					timeout, unit.toString().toLowerCase(), call, expectedAsList));
		}
		return myself;
	}

}
