package com.orange.assertw.core.api;

/**
 * .
 * 
 * @author Achraf LAHMOURATE
 */
public class AssertionsForWaitClassTypes {

	public static AbstractWaitBooleanAssert<?> assertThat(Boolean actual) {
		return new WaitBooleanAssert(actual);
	}

}
