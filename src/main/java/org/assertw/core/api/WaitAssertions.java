package org.assertw.core.api;

import java.util.concurrent.Callable;

/**
 * 
 * @author LAHMOURATE Achraf
 *
 */
public class WaitAssertions {

	public static AbstractWaitAssert<?> assertThat(final Callable<?> actual) {
		return new WaitRunnableAssert(actual);
	}

}
