package com.orange.assertw.core.api;

import org.assertj.core.internal.Booleans;

import com.jayway.awaitility.Awaitility;

/**
 * .
 * 
 * @author Achraf LAHMOURATE
 */
public abstract class AbstractWaitBooleanAssert<S extends AbstractWaitBooleanAssert<S>> extends WaitAssert<S, Boolean> {

	Booleans booleans = Booleans.instance();

	protected AbstractWaitBooleanAssert(Boolean actual, Class<?> selfType) {
		super(actual, selfType);
	}

	public S isTrue() {
		return isEqualTo(true);
	}

	public S isFalse() {
		return isEqualTo(false);
	}

	public S isEqualTo(boolean expected) {
		Awaitility.await().atMost(timeout, unit).until(() -> booleans.assertEqual(info, actual, expected));
		return myself;
	}

	public S isNotEqualTo(boolean other) {
		Awaitility.await().atMost(timeout, unit).until(() -> booleans.assertNotEqual(info, actual, other));
		return myself;
	}

}
