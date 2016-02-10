package org.assertw.core.api;

import java.util.Collection;
import java.util.concurrent.Callable;

/**
 * 
 * @author LAHMOURATE Achraf
 *
 */
public class WaitAssertions {

	public static WaitObjectAssert assertThat(final Callable<Object> actual) {
		return new WaitObjectAssert(actual);
	}

	public static WaitObjectsAssert assertThats(final Callable<Collection<?>> actual) {
		return new WaitObjectsAssert(actual);
	}

}
