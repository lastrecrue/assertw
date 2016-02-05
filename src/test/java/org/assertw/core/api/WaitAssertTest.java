package org.assertw.core.api;

import org.junit.Test;

public class WaitAssertTest {

	@Test()
	public void testBooleanSimple() {
		WaitAssertions.assertThat(true).as("coucou").isEqualTo(false);
	}	
}
