package org.assertw.core.api;

public class WaitAssertions {

	public static AbstractWaitBooleanAssert<?> assertThat(Boolean actual) {
		 return AssertionsForWaitClassTypes.assertThat(actual);
	}

}
