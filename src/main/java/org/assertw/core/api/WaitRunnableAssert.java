package org.assertw.core.api;

import java.util.concurrent.Callable;

/**
 * 
 * @author GVLJ3568
 *
 */
public class WaitRunnableAssert extends AbstractWaitAssert<WaitRunnableAssert> {

	protected WaitRunnableAssert(Callable<?> actual) {
		super(actual, WaitRunnableAssert.class);
	}
}
