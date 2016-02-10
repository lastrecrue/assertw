package org.assertw.core.api;

import java.util.concurrent.Callable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.assertj.core.api.AbstractAssert;

public class AbstractWaitAssert<S extends AbstractWaitAssert<S, A,T>, A extends Callable<T>, T> extends AbstractAssert<S, A> {

	protected T call;
	
	static final Logger logger = LogManager.getLogger(AbstractWaitAssert.class.getName());

	protected AbstractWaitAssert(A actual, Class<?> selfType) {
		super(actual, selfType);
	}

	protected void call() {
		try {
			call = actual.call();
		} catch (Exception e) {
			logger.debug(e);
		}
	}

}
