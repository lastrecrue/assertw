package org.assertw.core.api;

import java.util.concurrent.TimeUnit;

import org.assertj.core.api.AbstractAssert;

import com.jayway.awaitility.Awaitility;

public class WaitAssert<S> extends AbstractAssert<WaitAssert<S>, S> {

	private long timeout;
	private TimeUnit unit;

	protected WaitAssert(S actual, Class<?> selfType, long timeout, TimeUnit unit) {
		super(actual, selfType);
		this.timeout = timeout;
		this.unit = unit;
	}

	protected WaitAssert(S actual, Class<?> selfType, long timeout) {
		super(actual, selfType);
		this.timeout = timeout;
		this.unit = TimeUnit.SECONDS;
	}

	public WaitAssert<S> isEqualTo(Object expected) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isEqualTo(expected));
		return myself;
	}

	/**
	 * Verifies that the actual value is not equal to the given one.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> // assertions will pass
	 * assertThat(&quot;abc&quot;).isNotEqualTo(&quot;123&quot;);
	 * assertThat(new ArrayList&lt;String&gt;()).isNotEqualTo(1);
	 * 
	 * // assertions will fail
	 * assertThat(&quot;abc&quot;).isNotEqualTo(&quot;abc&quot;);
	 * assertThat(new HashMap&lt;String, Integer&gt;()).isNotEqualTo(new HashMap&lt;String, Integer&gt;());</code>
	 * </pre>
	 * </p>
	 * 
	 * @param other
	 *            the given value to compare the actual value to.
	 * @return {@code this} assertion object.
	 * @throws AssertionError
	 *             if the actual value is equal to the given one.
	 */
	public WaitAssert<S> isNotEqualTo(Object other) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNotEqualTo(other));
		return myself;
	}

	/**
	 * Verifies that the actual value is {@code null}.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> String value = null;
	 * // assertion will pass
	 * assertThat(value).isNull();
	 * 
	 * // assertions will fail
	 * assertThat(&quot;abc&quot;).isNull();
	 * assertThat(new HashMap&lt;String, Integer&gt;()).isNull();</code>
	 * </pre>
	 * </p>
	 * 
	 * @throws AssertionError
	 *             if the actual value is not {@code null}.
	 */
	public void isNull() {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNull());
	}

	/**
	 * Verifies that the actual value is not {@code null}.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> // assertion will pass
	 * assertThat(&quot;abc&quot;).isNotNull();
	 * assertThat(new HashMap&lt;String, Integer&gt;()).isNotNull();
	 * 
	 * // assertion will fail
	 * String value = null;
	 * assertThat(value).isNotNull();</code>
	 * </pre>
	 * </p>
	 * 
	 * @return {@code this} assertion object.
	 * @throws AssertionError
	 *             if the actual value is {@code null}.
	 */
	public WaitAssert<S> isNotNull() {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNotNull());
		return myself;
	}

	/**
	 * Verifies that the actual value is the same as the given one, ie using ==
	 * comparison.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> // Name is a class with first and last fields, two Names are equals if both first and last are equals.
	 * Name tyrion = new Name("Tyrion", "Lannister");
	 * Name alias  = tyrion;
	 * Name clone  = new Name("Tyrion", "Lannister");
	 * 
	 * // assertions succeed:
	 * assertThat(tyrion).isSameAs(alias)
	 *                   .isEqualTo(clone);
	 *                      
	 * // assertion fails:
	 * assertThat(tyrion).isSameAs(clone);</code>
	 * </pre>
	 * 
	 * @param expected
	 *            the given value to compare the actual value to.
	 * @return {@code this} assertion object.
	 * @throws AssertionError
	 *             if the actual value is not the same as the given one.
	 */
	public WaitAssert<S> isSameAs(Object expected) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isSameAs(expected));
		return myself;
	}

	/**
	 * Verifies that the actual value is not the same as the given one, ie using
	 * == comparison.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> // Name is a class with first and last fields, two Names are equals if both first and last are equals.
	 * Name tyrion = new Name("Tyrion", "Lannister");
	 * Name alias  = tyrion;
	 * Name clone  = new Name("Tyrion", "Lannister");
	 * 
	 * // assertions succeed:
	 * assertThat(clone).isNotSameAs(tyrion)
	 *                  .isEqualTo(tyrion);
	 *                      
	 * // assertion fails:
	 * assertThat(alias).isNotSameAs(tyrion);</code>
	 * </pre>
	 * 
	 * @param other
	 *            the given value to compare the actual value to.
	 * @return {@code this} assertion object.
	 * @throws AssertionError
	 *             if the actual value is the same as the given one.
	 */
	public WaitAssert<S> isNotSameAs(Object other) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNotSameAs(other));
		return myself;
	}

	/**
	 * Verifies that the actual value is present in the given array of values.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> Ring[] elvesRings = new Ring[] { vilya, nenya, narya };
	 * 
	 * // assertions will pass:
	 * assertThat(nenya).isIn(elvesRings);
	 * 
	 * // assertions will fail:
	 * assertThat(oneRing).isIn(elvesRings);</code>
	 * </pre>
	 * 
	 * @param values
	 *            the given array to search the actual value in.
	 * @return {@code this} assertion object.
	 * @throws NullPointerException
	 *             if the given array is {@code null}.
	 * @throws IllegalArgumentException
	 *             if the given array is empty.
	 * @throws AssertionError
	 *             if the actual value is not present in the given array.
	 */
	public WaitAssert<S> isIn(Object... values) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isIn(values));
		return myself;
	}

	/**
	 * Verifies that the actual value is not present in the given array of
	 * values.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> Ring[] elvesRings = new Ring[] { vilya, nenya, narya };
	 * 
	 * // assertions will pass:
	 * assertThat(oneRing).isNotIn(elvesRings);
	 * 
	 * // assertions will fail:
	 * assertThat(nenya).isNotIn(elvesRings);</code>
	 * </pre>
	 * 
	 * @param values
	 *            the given array to search the actual value in.
	 * @return {@code this} assertion object.
	 * @throws NullPointerException
	 *             if the given array is {@code null}.
	 * @throws IllegalArgumentException
	 *             if the given array is empty.
	 * @throws AssertionError
	 *             if the actual value is present in the given array.
	 */
	public WaitAssert<S> isNotIn(Object... values) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNotIn(values));
		return myself;
	}

	/**
	 * Verifies that the actual value is present in the given values.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> Iterable&lt;Ring&gt; elvesRings = newArrayList(vilya, nenya, narya);
	 * 
	 * // assertions will pass:
	 * assertThat(nenya).isIn(elvesRings);
	 * 
	 * // assertions will fail:
	 * assertThat(oneRing).isIn(elvesRings);</code>
	 * </pre>
	 * 
	 * @param values
	 *            the given iterable to search the actual value in.
	 * @return {@code this} assertion object.
	 * @throws NullPointerException
	 *             if the given collection is {@code null}.
	 * @throws IllegalArgumentException
	 *             if the given collection is empty.
	 * @throws AssertionError
	 *             if the actual value is not present in the given collection.
	 */
	public WaitAssert<S> isIn(Iterable<?> values) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isIn(values));
		return myself;
	}

	/**
	 * Verifies that the actual value is not present in the given values.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> Iterable&lt;Ring&gt; elvesRings = newArrayList(vilya, nenya, narya);
	 * 
	 * // assertions will pass:
	 * assertThat(oneRing).isNotIn(elvesRings);
	 * 
	 * // assertions will fail:
	 * assertThat(nenya).isNotIn(elvesRings);</code>
	 * </pre>
	 * 
	 * @param values
	 *            the given iterable to search the actual value in.
	 * @return {@code this} assertion object.
	 * @throws NullPointerException
	 *             if the given collection is {@code null}.
	 * @throws IllegalArgumentException
	 *             if the given collection is empty.
	 * @throws AssertionError
	 *             if the actual value is present in the given collection.
	 */
	public WaitAssert<S> isNotIn(Iterable<?> values) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNotIn(values));
		return myself;
	}

	/**
	 * Verifies that the actual value is an instance of the given type.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> // assertions will pass
	 * assertThat(&quot;abc&quot;).isInstanceOf(String.class);
	 * assertThat(new HashMap&lt;String, Integer&gt;()).isInstanceOf(HashMap.class);
	 * assertThat(new HashMap&lt;String, Integer&gt;()).isInstanceOf(Map.class);
	 * 
	 * // assertions will fail
	 * assertThat(1).isInstanceOf(String.class);
	 * assertThat(new ArrayList&lt;String&gt;()).isInstanceOf(LinkedList.class);</code>
	 * </pre>
	 * </p>
	 * 
	 * @param type
	 *            the type to check the actual value against.
	 * @return this assertion object.
	 * @throws NullPointerException
	 *             if the given type is {@code null}.
	 * @throws AssertionError
	 *             if the actual value is {@code null}.
	 * @throws AssertionError
	 *             if the actual value is not an instance of the given type.
	 */
	public WaitAssert<S> isInstanceOf(Class<?> type) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isInstanceOf(type));
		return myself;
	}

	/**
	 * Verifies that the actual value is an instance of any of the given types.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> // assertions will pass
	 * assertThat(&quot;abc&quot;).isInstanceOfAny(String.class, Integer.class);
	 * assertThat(new ArrayList&lt;String&gt;()).isInstanceOfAny(LinkedList.class, ArrayList.class);
	 * assertThat(new HashMap&lt;String, Integer&gt;()).isInstanceOfAny(TreeMap.class, Map.class);
	 * 
	 * // assertions will fail
	 * assertThat(1).isInstanceOfAny(Double.class, Float.class);
	 * assertThat(new ArrayList&lt;String&gt;()).isInstanceOfAny(LinkedList.class, Vector.class);</code>
	 * </pre>
	 * </p>
	 * 
	 * @param types
	 *            the types to check the actual value against.
	 * @return this assertion object.
	 * @throws AssertionError
	 *             if the actual value is {@code null}.
	 * @throws AssertionError
	 *             if the actual value is not an instance of any of the given
	 *             types.
	 * @throws NullPointerException
	 *             if the given array of types is {@code null}.
	 * @throws NullPointerException
	 *             if the given array of types contains {@code null}s.
	 */
	public WaitAssert<S> isInstanceOfAny(Class<?>... types) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isInstanceOfAny(types));
		return myself;
	}

	/**
	 * Verifies that the actual value is not an instance of the given type.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> // assertions will pass
	 * assertThat(1).isNotInstanceOf(Double.class);
	 * assertThat(new ArrayList&lt;String&gt;()).isNotInstanceOf(LinkedList.class);
	 * 
	 * // assertions will fail
	 * assertThat(&quot;abc&quot;).isNotInstanceOf(String.class);
	 * assertThat(new HashMap&lt;String, Integer&gt;()).isNotInstanceOf(HashMap.class);
	 * assertThat(new HashMap&lt;String, Integer&gt;()).isNotInstanceOf(Map.class);</code>
	 * </pre>
	 * </p>
	 * 
	 * @param type
	 *            the type to check the actual value against.
	 * @return this assertion object.
	 * @throws NullPointerException
	 *             if the given type is {@code null}.
	 * @throws AssertionError
	 *             if the actual value is {@code null}.
	 * @throws AssertionError
	 *             if the actual value is an instance of the given type.
	 */
	public WaitAssert<S> isNotInstanceOf(Class<?> type) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNotInstanceOf(type));
		return myself;
	}

	/**
	 * Verifies that the actual value is not an instance of any of the given
	 * types.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> // assertions will pass
	 * assertThat(1).isNotInstanceOfAny(Double.class, Float.class);
	 * assertThat(new ArrayList&lt;String&gt;()).isNotInstanceOfAny(LinkedList.class, Vector.class);
	 * 
	 * // assertions will fail
	 * assertThat(1).isNotInstanceOfAny(Double.class, Integer.class);
	 * assertThat(new ArrayList&lt;String&gt;()).isNotInstanceOfAny(LinkedList.class, ArrayList.class);
	 * assertThat(new HashMap&lt;String, Integer&gt;()).isNotInstanceOfAny(TreeMap.class, Map.class);</code>
	 * </pre>
	 * </p>
	 * 
	 * @param types
	 *            the types to check the actual value against.
	 * @return this assertion object.
	 * @throws AssertionError
	 *             if the actual value is {@code null}.
	 * @throws AssertionError
	 *             if the actual value is an instance of any of the given types.
	 * @throws NullPointerException
	 *             if the given array of types is {@code null}.
	 * @throws NullPointerException
	 *             if the given array of types contains {@code null}s.
	 */
	public WaitAssert<S> isNotInstanceOfAny(Class<?>... types) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNotInstanceOfAny(types));
		return myself;
	}

	/**
	 * Verifies that the actual value has the same class as the given object.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> // assertions will pass
	 * assertThat(1).hasSameClassAs(2);
	 * assertThat(&quot;abc&quot;).hasSameClassAs(&quot;123&quot;);
	 * assertThat(new ArrayList&lt;String&gt;()).hasSameClassAs(new ArrayList&lt;Integer&gt;());
	 * 
	 * // assertions will fail
	 * assertThat(1).hasSameClassAs(&quot;abc&quot;);
	 * assertThat(new ArrayList&lt;String&gt;()).hasSameClassAs(new LinkedList&lt;String&gt;());</code>
	 * </pre>
	 * </p>
	 * 
	 * @param other
	 *            the object to check type against.
	 * @return this assertion object.
	 * @throws AssertionError
	 *             if the actual has not the same type has the given object.
	 * @throws NullPointerException
	 *             if the actual value is null.
	 * @throws NullPointerException
	 *             if the given object is null.
	 */
	public WaitAssert<S> hasSameClassAs(Object other) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.hasSameClassAs(other));
		return myself;
	}

	/**
	 * Verifies that actual <code>actual.toString()</code> is equal to the given
	 * <code>String</code>.
	 * <p>
	 * Example :
	 * 
	 * <pre>
	 * <code class='java'> CartoonCaracter homer = new CartoonCaracter("Homer");
	 *
	 * // Instead of writing ...  
	 * assertThat(homer.toString()).isEqualTo("Homer");
	 * // ... you can simply write: 
	 * assertThat(homer).hasToString("Homer");</code>
	 * </pre>
	 * 
	 * @param expectedToString
	 *            the expected String description of actual.
	 * @return this assertion object.
	 * @throws AssertionError
	 *             if <code>actual.toString()</code> result is not to the given
	 *             <code>String</code>.
	 * @throws AssertionError
	 *             if actual is {@code null}.
	 */
	public WaitAssert<S> hasToString(String expectedToString) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.hasToString(expectedToString));
		return myself;
	}

	/**
	 * Verifies that the actual value does not have the same class as the given
	 * object.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> // assertions will pass
	 * assertThat(1).doesNotHaveSameClassAs(&quot;abc&quot;);
	 * assertThat(new ArrayList&lt;String&gt;()).doesNotHaveSameClassAs(new LinkedList&lt;String&gt;());
	 * 
	 * // assertions will fail
	 * assertThat(1).doesNotHaveSameClassAs(2);
	 * assertThat(&quot;abc&quot;).doesNotHaveSameClassAs(&quot;123&quot;);
	 * assertThat(new ArrayList&lt;String&gt;()).doesNotHaveSameClassAs(new ArrayList&lt;Integer&gt;());</code>
	 * </pre>
	 * </p>
	 * 
	 * @param other
	 *            the object to check type against.
	 * @return this assertion object.
	 * @throws AssertionError
	 *             if the actual has the same type has the given object.
	 * @throws NullPointerException
	 *             if the actual value is null.
	 * @throws NullPointerException
	 *             if the given object is null.
	 */
	public WaitAssert<S> doesNotHaveSameClassAs(Object other) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.doesNotHaveSameClassAs(other));
		return myself;
	}

	/**
	 * Verifies that the actual value is <b>exactly</b> an instance of the given
	 * type.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> // assertions will pass
	 * assertThat(&quot;abc&quot;).isExactlyInstanceOf(String.class);
	 * assertThat(new ArrayList&lt;String&gt;()).isExactlyInstanceOf(ArrayList.class);
	 * assertThat(new HashMap&lt;String, Integer&gt;()).isExactlyInstanceOf(HashMap.class);
	 * 
	 * // assertions will fail
	 * assertThat(1).isExactlyInstanceOf(String.class);
	 * assertThat(new ArrayList&lt;String&gt;()).isExactlyInstanceOf(List.class);
	 * assertThat(new HashMap&lt;String, Integer&gt;()).isExactlyInstanceOf(Map.class);</code>
	 * </pre>
	 * </p>
	 * 
	 * @param type
	 *            the type to check the actual value against.
	 * @return this assertion object.
	 * @throws AssertionError
	 *             if the actual is not <b>exactly</b> an instance of given
	 *             type.
	 * @throws NullPointerException
	 *             if the actual value is null.
	 * @throws NullPointerException
	 *             if the given object is null.
	 */
	public WaitAssert<S> isExactlyInstanceOf(Class<?> type) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isExactlyInstanceOf(type));
		return myself;

	}

	/**
	 * Verifies that the actual value is not <b>exactly</b> an instance of given
	 * type.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> // assertions will pass
	 * assertThat(1).isNotExactlyInstanceOf(String.class);
	 * assertThat(new ArrayList&lt;String&gt;()).isNotExactlyInstanceOf(List.class);
	 * assertThat(new HashMap&lt;String, Integer&gt;()).isNotExactlyInstanceOf(Map.class);
	 * 
	 * // assertions will fail
	 * assertThat(&quot;abc&quot;).isNotExactlyInstanceOf(String.class);
	 * assertThat(new ArrayList&lt;String&gt;()).isNotExactlyInstanceOf(ArrayList.class);
	 * assertThat(new HashMap&lt;String, Integer&gt;()).isNotExactlyInstanceOf(HashMap.class);</code>
	 * </pre>
	 * </p>
	 * 
	 * @param type
	 *            the type to check the actual value against.
	 * @return this assertion object.
	 * @throws AssertionError
	 *             if the actual is exactly a instance of given type.
	 * @throws NullPointerException
	 *             if the actual value is null.
	 * @throws NullPointerException
	 *             if the given object is null.
	 */
	public WaitAssert<S> isNotExactlyInstanceOf(Class<?> type) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNotExactlyInstanceOf(type));
		return myself;
	}

	/**
	 * Verifies that the actual value type is in given types.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> // assertions will pass
	 * assertThat(new HashMap&lt;String, Integer&gt;()).isOfAnyClassIn(HashMap.class, TreeMap.class);
	 * assertThat(new ArrayList&lt;String&gt;()).isOfAnyClassIn(ArrayList.class, LinkedList.class);
	 * 
	 * // assertions will fail
	 * assertThat(new HashMap&lt;String, Integer&gt;()).isOfAnyClassIn(TreeMap.class, Map.class);
	 * assertThat(new ArrayList&lt;String&gt;()).isOfAnyClassIn(LinkedList.class, List.class);</code>
	 * </pre>
	 * </p>
	 * 
	 * @param types
	 *            the types to check the actual value against.
	 * @return this assertion object.
	 * @throws AssertionError
	 *             if the actual value type is not in given type.
	 * @throws NullPointerException
	 *             if the actual value is null.
	 * @throws NullPointerException
	 *             if the given types is null.
	 */
	public WaitAssert<S> isOfAnyClassIn(Class<?>... types) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isOfAnyClassIn(types));
		return myself;
	}

	/**
	 * Verifies that the actual value type is not in given types.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code class='java'> // assertions will pass
	 * assertThat(new HashMap&lt;String, Integer&gt;()).isNotOfAnyClassIn(Map.class, TreeMap.class);
	 * assertThat(new ArrayList&lt;String&gt;()).isNotOfAnyClassIn(LinkedList.class, List.class);
	 * 
	 * // assertions will fail
	 * assertThat(new HashMap&lt;String, Integer&gt;()).isNotOfAnyClassIn(HashMap.class, TreeMap.class);
	 * assertThat(new ArrayList&lt;String&gt;()).isNotOfAnyClassIn(ArrayList.class, LinkedList.class);</code>
	 * </pre>
	 * </p>
	 * 
	 * @param types
	 *            the types to check the actual value against.
	 * @return this assertion object.
	 * @throws AssertionError
	 *             if the actual value type is in given types.
	 * @throws NullPointerException
	 *             if the actual value is null.
	 * @throws NullPointerException
	 *             if the given types is null.
	 */
	public WaitAssert<S> isNotOfAnyClassIn(Class<?>... types) {
		Awaitility.await().atMost(timeout, unit).until(() -> super.isNotOfAnyClassIn(types));
		return myself;
	}

}
