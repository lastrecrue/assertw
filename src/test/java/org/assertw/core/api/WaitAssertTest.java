package org.assertw.core.api;

import java.util.Random;
import java.util.concurrent.Callable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 
 * @author LAHMOURATE Achraf
 *
 */
public class WaitAssertTest {

	static final Logger logger = LogManager.getLogger(WaitAssertTest.class.getName());

	@Test
	public void testBooleanTrue() {
		Callable<?> actual = new Callable<Boolean>() {

			@Override
			public Boolean call() throws Exception {
				// TODO Auto-generated method stub
				return randBoolean();
			}
		};
		;
		WaitAssertions.assertThat(actual).atMost(5).isEqualTo(true);
	}

	private boolean randBoolean() {
		boolean nextBoolean = new Random().nextBoolean();
		logger.debug(nextBoolean);
		return false;
	}
}
