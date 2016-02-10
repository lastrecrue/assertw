package org.assertw.core.api;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.AbstractAssert;

/**
 * .
 * 
 * @author LAHMOURATE Achraf
 * 
 */
public abstract class AbstractWaitAssert<S extends AbstractWaitAssert<S>> extends AbstractAssert<S, Callable<?>> {

	protected long timeout = 5;
	protected TimeUnit unit = TimeUnit.SECONDS;

	protected long pollInterval = 1;
	protected TimeUnit pollUnit = TimeUnit.SECONDS;

	protected AbstractWaitAssert(Callable<?> actual, Class<?> selfType) {
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

	public S isEqualTo(final Object expected) {
		long start = System.currentTimeMillis();
		while (true) {
			Object call = null;
			try {
				call = actual.call();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (call.equals(expected)) {
				return myself;
			} else if (System.currentTimeMillis() - start > unit.toMillis(timeout)) {
				throw new RuntimeException(String.format("time out %s.", timeout));
			} else {
				try {
					Thread.sleep(pollUnit.toMillis(pollInterval));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
