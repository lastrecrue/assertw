package org.assertw.core.api;

import java.util.concurrent.Callable;

/**
 * 
 * @author GVLJ3568
 *
 */
public class WaitObjectAssert extends AbstractObjectWaitAssert<WaitObjectAssert> {

	protected WaitObjectAssert(Callable<?> actual) {
		super(actual, WaitObjectAssert.class);
	}
}
