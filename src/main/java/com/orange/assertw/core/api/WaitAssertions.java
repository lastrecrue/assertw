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
	public static AbstractBooleanWaitAssert<?> assertThat(Boolean actual) {
		return WaitAssertionsForClassTypes.assertThat(actual);
	}

}
