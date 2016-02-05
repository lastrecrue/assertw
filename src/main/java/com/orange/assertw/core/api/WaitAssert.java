package com.orange.assertw.core.api;

import java.util.concurrent.TimeUnit;

import org.assertj.core.api.AbstractAssert;

import com.jayway.awaitility.Awaitility;

/**
 * .
 * 
 * @author Achraf LAHMOURATE
 */
public class WaitAssert<S extends WaitAssert<S, A>, A> extends AbstractAssert<S, A> {

	protected long timeout = 5;
	protected TimeUnit unit = TimeUnit.SECONDS;

	protected WaitAssert(A actual, Class<?> selfType) {
		super(actual, selfType);
	}

	public S atMost(long timeout) {
		this.timeout = timeout;
		return myself;
	}

	public void atMost(long timeout, TimeUnit unit) {
		this.timeout = timeout;
		this.unit = unit;
	}

	@Override
	public S isEqualTo(Object expected) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isEqualTo(expected));
		return myself;
	}

	@Override
	public S isNotEqualTo(Object other) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNotEqualTo(other));
		return myself;
	}

	@Override
	public void isNull() {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNull());
	}

	@Override
	public S isNotNull() {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNotNull());
		return myself;
	}

	@Override
	public S isSameAs(Object expected) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isSameAs(expected));
		return myself;
	}

	@Override
	public S isNotSameAs(Object other) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNotSameAs(other));
		return myself;
	}

	@Override
	public S isIn(Object... values) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isIn(values));
		return myself;
	}

	@Override
	public S isNotIn(Object... values) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNotIn(values));
		return myself;
	}

	@Override
	public S isIn(Iterable<?> values) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isIn(values));
		return myself;
	}

	@Override
	public S isNotIn(Iterable<?> values) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNotIn(values));
		return myself;
	}

	@Override
	public S isInstanceOf(Class<?> type) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isInstanceOf(type));
		return myself;
	}

	@Override
	public S isInstanceOfAny(Class<?>... types) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isInstanceOfAny(types));
		return myself;
	}

	@Override
	public S isNotInstanceOf(Class<?> type) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNotInstanceOf(type));
		return myself;
	}

	@Override
	public S isNotInstanceOfAny(Class<?>... types) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNotInstanceOfAny(types));
		return myself;
	}

	@Override
	public S hasSameClassAs(Object other) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.hasSameClassAs(other));
		return myself;
	}

	@Override
	public S hasToString(String expectedToString) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.hasToString(expectedToString));
		return myself;
	}

	@Override
	public S doesNotHaveSameClassAs(Object other) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.doesNotHaveSameClassAs(other));
		return myself;
	}

	@Override
	public S isExactlyInstanceOf(Class<?> type) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isExactlyInstanceOf(type));
		return myself;

	}

	@Override
	public S isNotExactlyInstanceOf(Class<?> type) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNotExactlyInstanceOf(type));
		return myself;
	}

	@Override
	public S isOfAnyClassIn(Class<?>... types) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isOfAnyClassIn(types));
		return myself;
	}

	@Override
	public S isNotOfAnyClassIn(Class<?>... types) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNotOfAnyClassIn(types));
		return myself;
	}

}
