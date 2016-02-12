package org.assertw.core.api;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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
public abstract class AbstractObjectsWaitAssert<S extends AbstractObjectsWaitAssert<S>>
		extends AbstractWaitAssert<S, Callable<Collection<?>>, Collection<?>> {

	static final Logger logger = LogManager.getLogger(AbstractObjectsWaitAssert.class.getName());

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
					pool();
				}

			}
		};
		waitTest(expectedAsList, task);
		return myself;
	}

	public S containsOnly(Object... expected) {
		List<Object> expectedAsList = Arrays.asList(expected);
		Runnable task = new Runnable() {

			@Override
			public void run() {
				while (!Thread.interrupted()) {
					call();
					if (actualIncludeExpected(call, expectedAsList)) {
						return;
					}
					pool();
				}

			}

		};
		waitTest(expectedAsList, task);
		return myself;
	}

	private boolean actualIncludeExpected(Collection<?> actual, Collection<?> expected) {
		for (Object object : actual) {
			if (!expected.contains(object)) {
				return false;
			}
		}
		return true;
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
