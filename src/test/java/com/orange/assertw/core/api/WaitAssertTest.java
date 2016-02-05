package com.orange.assertw.core.api;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.jayway.awaitility.core.ConditionTimeoutException;

/**
 * .
 * 
 * @author Achraf LAHMOURATE
 */
public class WaitAssertTest {

  @Test
  public void testBooleanAtMostModification() {
    try {
      WaitAssertions.assertThat(true).atMost(2).isEqualTo(false);
    } catch (ConditionTimeoutException cte) {
      Assertions.assertThat(cte).hasMessageContaining("2 seconds");
    }
  }

  @Test
  public void testBooleanTrue() {
    WaitAssertions.assertThat(true).atMost(2).isEqualTo(true);
  }
}
