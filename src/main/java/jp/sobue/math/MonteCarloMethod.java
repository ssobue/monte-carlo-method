package jp.sobue.math;

import java.security.SecureRandom;
import java.util.random.RandomGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * モンテカルロ法で円周率を出す.
 *
 * @author ssobue
 */
public class MonteCarloMethod {

  /** ロガー. */
  private static final Logger LOGGER = LoggerFactory.getLogger(MonteCarloMethod.class);

  /** 乱数生成器. */
  private static final RandomGenerator RANDOM = new SecureRandom();

  /** 繰り返し回数. */
  private static final long MAX_ITERATION = 100_000_000L;

  /**
   * Main method.
   *
   * @param args Command line arguments. The first argument can override the iteration count.
   */
  public static void main(String[] args) {
    long iteration = args.length == 0 ? MAX_ITERATION : Long.parseLong(args[0]);
    Result result = calculate(iteration);

    // 結果表示
    LOGGER.info("Iteration = {}", result.iteration());
    LOGGER.info("Inside = {}", result.inside());
    LOGGER.info("Outside = {}", result.outside());

    LOGGER.info("PI = {}", result.pi());
  }

  /**
   * 座標(x,y)が円の範囲内判定する.
   *
   * @param x x-value
   * @param y y-value
   * @return 円の範囲内か
   */
  static boolean isInsideCircle(double x, double y) {
    // √(x^2 + y^2)が1以下
    return Math.sqrt((x * x) + (y * y)) <= 1.0;
  }

  /**
   * 指定回数で円周率を計算する.
   *
   * @param iteration 繰り返し回数
   * @return 計算した円周率
   */
  static double calculatePi(long iteration) {
    return calculate(iteration).pi();
  }

  /**
   * 指定回数でモンテカルロ法を実行する.
   *
   * @param iteration 繰り返し回数
   * @return 計算結果
   */
  static Result calculate(long iteration) {
    long inside = 0L;
    for (long i = 0; i < iteration; i++) {
      if (isInsideCircle(RANDOM.nextDouble(), RANDOM.nextDouble())) {
        inside++;
      }
    }
    return new Result(iteration, inside);
  }

  /**
   * モンテカルロ法の計算結果.
   *
   * @param iteration 繰り返し回数
   * @param inside 円の範囲内とカウントされた回数
   */
  record Result(long iteration, long inside) {

    long outside() {
      return iteration - inside;
    }

    double pi() {
      return ((double) inside / (double) iteration) * 4.0;
    }
  }
}
