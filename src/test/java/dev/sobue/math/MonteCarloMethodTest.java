package dev.sobue.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MonteCarloMethodTest {

  @Test
  @DisplayName("Run application: iteration override should execute the result flow")
  void runApplication() {
    assertDoesNotThrow(() -> MonteCarloMethod.main(new String[]{"1"}));
  }

  @Test
  @DisplayName("Create calculator: the default constructor should be available")
  void createCalculator() {
    MonteCarloMethod calculator = new MonteCarloMethod();

    assertNotNull(calculator);
  }

  @Test
  @DisplayName("Check circle inclusion: origin is inside and diagonal edge is outside")
  void checkCircleInclusion() {
    assertTrue(MonteCarloMethod.isInsideCircle(0.0, 0.0));
    assertFalse(MonteCarloMethod.isInsideCircle(1.0, 1.0));
  }

  @Test
  @DisplayName("Estimate pi: a few thousand random trials should stay close to Math.PI")
  void estimatePi() {
    double pi = MonteCarloMethod.calculatePi(5000L);
    // Approximation should be within 0.2 of actual PI for few thousand iterations
    assertEquals(Math.PI, pi, 0.2);
  }

  @Test
  @DisplayName("Summarize result: outside count and pi value are derived")
  void summarizeResult() {
    MonteCarloMethod.Result result = new MonteCarloMethod.Result(10L, 8L);

    assertEquals(2L, result.outside());
    assertEquals(3.2, result.pi());
  }
}
