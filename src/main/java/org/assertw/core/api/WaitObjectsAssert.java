package org.assertw.core.api;

import java.util.Collection;
import java.util.concurrent.Callable;

/**
 * 
 * @author GVLJ3568
 *
 */
public class WaitObjectsAssert extends AbstractObjectsWaitAssert<WaitObjectsAssert> {

	protected WaitObjectsAssert(Callable<Collection<?>> actual) {
		super(actual, WaitObjectsAssert.class);
	}

}
