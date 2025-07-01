package jp.sobue.math;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MonteCarloMethodTest {

  @Test
  void testIsInsideCircle() {
    assertTrue(MonteCarloMethod.isInsideCircle(0.0, 0.0));
    assertFalse(MonteCarloMethod.isInsideCircle(1.0, 1.0));
  }

  @Test
  void testCalculatePiApproximation() {
    double pi = MonteCarloMethod.calculatePi(5000L);
    // Approximation should be within 0.2 of actual PI for few thousand iterations
    assertEquals(Math.PI, pi, 0.2);
  }
}
