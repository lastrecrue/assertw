package com.orange.assertw.core.api;

/**
 * .
 * 
 * @author Achraf LAHMOURATE
 */
public class WaitAssertions {
	/**
	 * 
	 * @param actual
	 * @return
	 */
	public static AbstractWaitBooleanAssert<?> assertThat(Boolean actual) {
		return AssertionsForWaitClassTypes.assertThat(actual);
	}

}
