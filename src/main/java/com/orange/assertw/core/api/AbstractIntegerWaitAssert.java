package com.orange.assertw.core.api;

import java.util.Comparator;

import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.assertj.core.internal.ComparatorBasedComparisonStrategy;
import org.assertj.core.internal.Integers;
import org.assertj.core.util.VisibleForTesting;

/**
 * @author LAHMOURATE Achraf
 * 
 */
public abstract class AbstractIntegerWaitAssert<S extends AbstractIntegerWaitAssert<S>>
    extends AbstractComparableWaitAssert<S, Integer> implements NumberWaitAssert<S, Integer> {

  @VisibleForTesting
  Integers integers = Integers.instance();

  protected AbstractIntegerWaitAssert(Integer actual, Class<?> selfType) {
    super(actual, selfType);
  }

  /**
   * Verifies that the actual value is equal to the given one.
   * <p>
   * Example:
   * 
   * <pre>
   * <code class='java'> // assertions will pass:
   * assertThat(1).isEqualTo(1);
   * assertThat(-1).isEqualTo(-1);
   * 
   * // assertions will fail:
   * assertThat(1).isEqualTo(2);
   * assertThat(1).isEqualTo(-1);</code>
   * </pre>
   * </p>
   * 
   * @param expected
   *          the given value to compare the actual value to.
   * @return {@code this} assertion object.
   * @throws AssertionError
   *           if the actual value is {@code null}.
   * @throws AssertionError
   *           if the actual value is not equal to the given one.
   */
  public S isEqualTo(int expected) {
    integers.assertEqual(info, actual, expected);
    return myself;
  }

  /**
   * Verifies that the actual value is not equal to the given one.
   * <p>
   * Example:
   * 
   * <pre>
   * <code class='java'> // assertions will pass:
   * assertThat(1).isNotEqualTo(2);
   * assertThat(1).isNotEqualTo(-1);
   * 
   * // assertion will fail:
   * assertThat(1).isNotEqualTo(1);</code>
   * </pre>
   * </p>
   * 
   * @param other
   *          the given value to compare the actual value to.
   * @return {@code this} assertion object.
   * @throws AssertionError
   *           if the actual value is {@code null}.
   * @throws AssertionError
   *           if the actual value is equal to the given one.
   */
  public S isNotEqualTo(int other) {
    integers.assertNotEqual(info, actual, other);
    return myself;
  }

  /** {@inheritDoc} */
  @Override
  public S isZero() {
    integers.assertIsZero(info, actual);
    return myself;
  }

  /** {@inheritDoc} */
  @Override
  public S isNotZero() {
    integers.assertIsNotZero(info, actual);
    return myself;
  }

  /** {@inheritDoc} */
  @Override
  public S isPositive() {
    integers.assertIsPositive(info, actual);
    return myself;
  }

  /** {@inheritDoc} */
  @Override
  public S isNegative() {
    integers.assertIsNegative(info, actual);
    return myself;
  }

  /** {@inheritDoc} */
  @Override
  public S isNotNegative() {
    integers.assertIsNotNegative(info, actual);
    return myself;
  }

  /** {@inheritDoc} */
  @Override
  public S isNotPositive() {
    integers.assertIsNotPositive(info, actual);
    return myself;
  }

  /**
   * Verifies that the actual value is less than the given one.
   * <p>
   * Example:
   * 
   * <pre>
   * <code class='java'> // assertions will pass:
   * assertThat(1).isLessThan(2);
   * assertThat(-2).isLessThan(-1);
   * 
   * // assertions will fail:
   * assertThat(1).isLessThan(0);
   * assertThat(1).isLessThan(1);</code>
   * </pre>
   * </p>
   * 
   * @param other
   *          the given value to compare the actual value to.
   * @return {@code this} assertion object.
   * @throws AssertionError
   *           if the actual value is {@code null}.
   * @throws AssertionError
   *           if the actual value is equal to or greater than the given one.
   */
  public S isLessThan(int other) {
    integers.assertLessThan(info, actual, other);
    return myself;
  }

  /**
   * Verifies that the actual value is less than or equal to the given one.
   * <p>
   * Example:
   * 
   * <pre>
   * <code class='java'> // assertions will pass:
   * assertThat(1).isLessThanOrEqualTo(2);
   * assertThat(-1).isLessThanOrEqualTo(-2);
   * assertThat(1).isLessThanOrEqualTo(1);
   * 
   * // assertions will fail:
   * assertThat(1).isLessThanOrEqualTo(2);
   * assertThat(-1).isLessThanOrEqualTo(-2);</code>
   * </pre>
   * </p>
   * 
   * @param other
   *          the given value to compare the actual value to.
   * @return {@code this} assertion object.
   * @throws AssertionError
   *           if the actual value is {@code null}.
   * @throws AssertionError
   *           if the actual value is greater than the given one.
   */
  public S isLessThanOrEqualTo(int other) {
    integers.assertLessThanOrEqualTo(info, actual, other);
    return myself;
  }

  /**
   * Verifies that the actual value is greater than the given one.
   * <p>
   * Example:
   * 
   * <pre>
   * <code class='java'> // assertions will pass:
   * assertThat(1).isGreaterThan(0);
   * assertThat(-1).isGreaterThan(-2);
   * 
   * // assertions will fail:
   * assertThat(1).isGreaterThan(2);
   * assertThat(1).isGreaterThan(1);</code>
   * </pre>
   * </p>
   * 
   * @param other
   *          the given value to compare the actual value to.
   * @return {@code this} assertion object.
   * @throws AssertionError
   *           if the actual value is {@code null}.
   * @throws AssertionError
   *           if the actual value is equal to or less than the given one.
   */
  public S isGreaterThan(int other) {
    integers.assertGreaterThan(info, actual, other);
    return myself;
  }

  /**
   * Verifies that the actual value is greater than or equal to the given one.
   * <p>
   * Example:
   * 
   * <pre>
   * <code class='java'> // assertions will pass:
   * assertThat(2).isGreaterThanOrEqualTo(1);
   * assertThat(1).isGreaterThanOrEqualTo(1);
   * 
   * // assertions will fail:
   * assertThat(1).isGreaterThanOrEqualTo(2);
   * assertThat(-1).isGreaterThanOrEqualTo(1);</code>
   * </pre>
   * </p>
   * 
   * @param other
   *          the given value to compare the actual value to.
   * @return {@code this} assertion object.
   * @throws AssertionError
   *           if the actual value is {@code null}.
   * @throws AssertionError
   *           if the actual value is less than the given one.
   */
  public S isGreaterThanOrEqualTo(int other) {
    integers.assertGreaterThanOrEqualTo(info, actual, other);
    return myself;
  }

  /** {@inheritDoc} */
  @Override
  public S isBetween(Integer start, Integer end) {
    integers.assertIsBetween(info, actual, start, end);
    return myself;
  }

  /** {@inheritDoc} */
  @Override
  public S isStrictlyBetween(Integer start, Integer end) {
    integers.assertIsStrictlyBetween(info, actual, start, end);
    return myself;
  }

  /**
   * Verifies that the actual int is close to the given one within the given offset.<br>
   * If difference is equal to offset value, assertion is considered valid.
   * <p>
   * Example:
   * 
   * <pre>
   * <code class='java'> // assertions will pass:
   * assertThat(5).isCloseTo(7, within(3));
   *
   * // if difference is exactly equals to the offset, it's ok
   * assertThat(5).isCloseTo(7, within(2));
   *
   * // assertion will fail
   * assertThat(5).isCloseTo(7, within(1));</code>
   * </pre>
   *
   * @param expected
   *          the given int to compare the actual value to.
   * @param offset
   *          the given positive offset.
   * @return {@code this} assertion object.
   * @throws NullPointerException
   *           if the given offset is {@code null}.
   * @throws AssertionError
   *           if the actual value is not equal to the given one.
   */
  public S isCloseTo(int expected, Offset<Integer> offset) {
    integers.assertIsCloseTo(info, actual, expected, offset);
    return myself;
  }

  /**
   * Verifies that the actual int is close to the given one within the given offset.<br>
   * If difference is equal to offset value, assertion is considered valid.
   * <p>
   * Example:
   * 
   * <pre>
   * <code class='java'> // assertions will pass:
   * assertThat(5).isCloseTo(Integer.valueOf(7), within(3));
   *
   * // if difference is exactly equals to the offset, it's ok
   * assertThat(5).isCloseTo(Integer.valueOf(7), within(2));
   *
   * // assertion will fail
   * assertThat(5).isCloseTo(Integer.valueOf(7), within(1));</code>
   * </pre>
   *
   * @param expected
   *          the given int to compare the actual value to.
   * @param offset
   *          the given positive offset.
   * @return {@code this} assertion object.
   * @throws NullPointerException
   *           if the given offset is {@code null}.
   * @throws AssertionError
   *           if the actual value is not equal to the given one.
   */
  @Override
  public S isCloseTo(Integer expected, Offset<Integer> offset) {
    integers.assertIsCloseTo(info, actual, expected, offset);
    return myself;
  }

  /**
   * Verifies that the actual number is close to the given one within the given percentage.<br>
   * If difference is equal to the percentage value, assertion is considered valid.
   * <p>
   * Example with integer:
   * 
   * <pre>
   * <code class='java'> // assertions will pass:
   * assertThat(11).isCloseTo(Integer.valueOf(10), withinPercentage(20));
   *
   * // if difference is exactly equals to the computed offset (1), it's ok
   * assertThat(11).isCloseTo(Integer.valueOf(10), withinPercentage(10));
   *
   * // assertion will fail
   * assertThat(11).isCloseTo(Integer.valueOf(10), withinPercentage(5));</code>
   * </pre>
   *
   * @param expected
   *          the given number to compare the actual value to.
   * @param percentage
   *          the given positive percentage between 0 and 100.
   * @return {@code this} assertion object.
   * @throws NullPointerException
   *           if the given offset is {@code null}.
   * @throws NullPointerException
   *           if the expected number is {@code null}.
   * @throws AssertionError
   *           if the actual value is not equal to the given one.
   */
  @Override
  public S isCloseTo(Integer expected, Percentage percentage) {
    integers.assertIsCloseToPercentage(info, actual, expected, percentage);
    return myself;
  }

  /**
   * Verifies that the actual number is close to the given one within the given percentage.<br>
   * If difference is equal to the percentage value, assertion is considered valid.
   * <p>
   * Example with integer:
   * 
   * <pre>
   * <code class='java'> // assertions will pass:
   * assertThat(11).isCloseTo(10, withinPercentage(20));
   *
   * // if difference is exactly equals to the computed offset (1), it's ok
   * assertThat(11).isCloseTo(10, withinPercentage(10));
   *
   * // assertion will fail
   * assertThat(11).isCloseTo(10, withinPercentage(5));</code>
   * </pre>
   *
   * @param expected
   *          the given number to compare the actual value to.
   * @param percentage
   *          the given positive percentage between 0 and 100.
   * @return {@code this} assertion object.
   * @throws NullPointerException
   *           if the given offset is {@code null}.
   * @throws NullPointerException
   *           if the expected number is {@code null}.
   * @throws AssertionError
   *           if the actual value is not equal to the given one.
   */
  public S isCloseTo(int expected, Percentage percentage) {
    integers.assertIsCloseToPercentage(info, actual, expected, percentage);
    return myself;
  }

  @Override
  public S usingComparator(Comparator<? super Integer> customComparator) {
    super.usingComparator(customComparator);
    integers = new Integers(new ComparatorBasedComparisonStrategy(customComparator));
    return myself;
  }

  @Override
  public S usingDefaultComparator() {
    super.usingDefaultComparator();
    integers = Integers.instance();
    return myself;
  }
}