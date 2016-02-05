package com.orange.assertw.core.api;

/**
 * .
 * 
 * @author Achraf LAHMOURATE
 */
public class WaitAssertionsForClassTypes {

	public static AbstractBooleanWaitAssert<?> assertThat(Boolean actual) {
		return new BooleanWaitAssert(actual);
	}

}
