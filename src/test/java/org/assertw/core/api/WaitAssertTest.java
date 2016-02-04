package org.assertw.core.api;

import org.junit.Test;

public class WaitAssertTest {

	@Test
	public void testStringSimple() {
		WaitAssertions.assertThat("test").isEqualTo("test");
	}

}
