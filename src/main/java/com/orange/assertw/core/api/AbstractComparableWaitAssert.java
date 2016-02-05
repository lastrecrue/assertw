package com.orange.assertw.core.api;

import java.util.Comparator;

import org.assertj.core.api.ComparableAssert;
import org.assertj.core.internal.Comparables;
import org.assertj.core.internal.ComparatorBasedComparisonStrategy;
import org.assertj.core.util.VisibleForTesting;

/**
 * @author LAHMOURATE Achraf
 */
public abstract class AbstractComparableWaitAssert<S extends AbstractComparableWaitAssert<S, A>, A extends Comparable<? super A>>
    extends AbstractObjectWaitAssert<S, A> implements ComparableWaitAssert<S, A> {

  @VisibleForTesting
  Comparables comparables = Comparables.instance();

  protected AbstractComparableWaitAssert(A actual, Class<?> selfType) {
    super(actual, selfType);
  }

  /** {@inheritDoc} */
  @Override
  public S isEqualByComparingTo(A other) {
    comparables.assertEqualByComparison(info, actual, other);
    return myself;
  }

  /** {@inheritDoc} */
  @Override
  public S isNotEqualByComparingTo(A other) {
    comparables.assertNotEqualByComparison(info, actual, other);
    return myself;
  }

  /** {@inheritDoc} */
  @Override
  public S isLessThan(A other) {
    comparables.assertLessThan(info, actual, other);
    return myself;
  }

  /** {@inheritDoc} */
  @Override
  public S isLessThanOrEqualTo(A other) {
    comparables.assertLessThanOrEqualTo(info, actual, other);
    return myself;
  }

  /** {@inheritDoc} */
  @Override
  public S isGreaterThan(A other) {
    comparables.assertGreaterThan(info, actual, other);
    return myself;
  }

  /** {@inheritDoc} */
  @Override
  public S isGreaterThanOrEqualTo(A other) {
    comparables.assertGreaterThanOrEqualTo(info, actual, other);
    return myself;
  }

  @Override
  public S usingComparator(Comparator<? super A> customComparator) {
    super.usingComparator(customComparator);
    this.comparables = new Comparables(new ComparatorBasedComparisonStrategy(customComparator));
    return myself;
  }

  @Override
  public S usingDefaultComparator() {
    super.usingDefaultComparator();
    this.comparables = Comparables.instance();
    return myself;
  }

  @Override
  public S inHexadecimal() {
    return super.inHexadecimal();
  }

  @Override
  public S inBinary() {
    return super.inBinary();
  }
}
