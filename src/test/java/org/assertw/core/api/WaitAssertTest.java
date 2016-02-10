package org.assertw.core.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	public void testObjectTrue() {
		WaitAssertions.assertThat(() -> randBoolean()).atMost(5).isEqualTo(true);

	}

	@Test
	public void testCollectionsTrue() {
		WaitAssertions.assertThats(() -> listStrings()).atMost(5).contains("a","b","c");

	}
	
	 public List<String> listStrings(){
		 ArrayList<String> arrayList = new ArrayList<String>();
		 arrayList.add("a");
		 arrayList.add("b");
		 arrayList.add("c");
		 arrayList.add("d");
		return arrayList;
	 }

	
	private boolean randBoolean() {
		boolean nextBoolean = new Random().nextBoolean();
		logger.debug(nextBoolean);
		return nextBoolean;
	}
}
