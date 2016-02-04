package org.assertw.core.api;

public class WaitAssertions {

	public static WaitAssert<String> assertThat(String actual) {
		return new WaitAssert<String>(actual, String.class, 10);
	}

}
