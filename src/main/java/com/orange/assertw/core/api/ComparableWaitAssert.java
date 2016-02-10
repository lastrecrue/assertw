package com.orange.assertw.core.api;

import java.math.BigDecimal;

/**
 * Assertion methods applicable to <code>{@link Comparable}</code>s.
 * 
 * @param <S>
 *          the "self" type of this assertion class. Please read &quot;
 *          <a href="http://bit.ly/1IZIRcY" target="_blank">Emulating 'self types' using Java
 *          Generics to simplify fluent API implementation</a>&quot; for more details.
 * @param <A>
 *          the type of the "actual" value.
 * 
 * @author LAHMOURATE Achraf
 */
public interface ComparableWaitAssert<S extends ComparableWaitAssert<S, A>, A extends Comparable<? super A>> {

  /**
   * Verifies that the actual value is equal to the given one by invoking
   * <code>{@link Comparable#compareTo(Object)}</code>.
   * <p>
   * Example:
   * 
   * <pre>
   * <code class='java'> // assertion will pass
   * assertThat(1.0).isEqualByComparingTo(1.0);
   * // assertion will pass because 8.0 is equal to 8.00 using {@link BigDecimal#compareTo(BigDecimal)}
   * assertThat(new BigDecimal(&quot;8.0&quot;)).isEqualByComparingTo(new BigDecimal(&quot;8.00&quot;));
   *
   * // assertion will fail
   * assertThat(new BigDecimal(1.0)).isEqualByComparingTo(new BigDecimal(2.0));</code>
   * </pre>
   * 
   * @param other
   *          the given value to compare the actual value to.
   * @return {@code this} assertion object.
   * @throws AssertionError
   *           if the actual value is {@code null}.
   * @throws AssertionError
   *           if the actual value is not equal when comparing to the given one.
   */
  S isEqualByComparingTo(A other);

  /**
   * Verifies that the actual value is not equal to the given one by invoking
   * <code>{@link Comparable#compareTo(Object)}</code>.
   * <p>
   * Example:
   * 
   * <pre>
   * <code class='java'> // assertion will pass
   * assertThat(new BigDecimal(1.0)).isNotEqualByComparingTo(new BigDecimal(2.0));
   *
   * // assertion will fail
   * assertThat(1.0).isNotEqualByComparingTo(1.0);
   * // assertion will fail because 8.0 is equal to 8.00 using {@link BigDecimal#compareTo(BigDecimal)}
   * assertThat(new BigDecimal(&quot;8.0&quot;)).isNotEqualByComparingTo(new BigDecimal(&quot;8.00&quot;));</code>
   * </pre>
   * 
   * @param other
   *          the given value to compare the actual value to.
   * @return {@code this} assertion object.
   * @throws AssertionError
   *           if the actual value is {@code null}.
   * @throws AssertionError
   *           if the actual value is equal when comparing to the given one.
   */
  S isNotEqualByComparingTo(A other);

  /**
   * Verifies that the actual value is less than the given one.
   * 
   * @param other
   *          the given value to compare the actual value to.
   * @return {@code this} assertion object.
   * @throws AssertionError
   *           if the actual value is {@code null}.
   * @throws AssertionError
   *           if the actual value is equal to or greater than the given one.
   */
  S isLessThan(A other);

  /**
   * Verifies that the actual value is less than or equal to the given one.
   * 
   * @param other
   *          the given value to compare the actual value to.
   * @return {@code this} assertion object.
   * @throws AssertionError
   *           if the actual value is {@code null}.
   * @throws AssertionError
   *           if the actual value is greater than the given one.
   */
  S isLessThanOrEqualTo(A other);

  /**
   * Verifies that the actual value is greater than the given one.
   * 
   * @param other
   *          the given value to compare the actual value to.
   * @return {@code this} assertion object.
   * @throws AssertionError
   *           if the actual value is {@code null}.
   * @throws AssertionError
   *           if the actual value is equal to or less than the given one.
   */
  S isGreaterThan(A other);

  /**
   * Verifies that the actual value is greater than or equal to the given one.
   * 
   * @param other
   *          the given value to compare the actual value to.
   * @return {@code this} assertion object.
   * @throws AssertionError
   *           if the actual value is {@code null}.
   * @throws AssertionError
   *           if the actual value is less than the given one.
   */
  S isGreaterThanOrEqualTo(A other);
}