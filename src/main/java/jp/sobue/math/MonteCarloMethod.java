package jp.sobue.math;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

/**
 * モンテカルロ法で円周率を出す.
 *
 * @author ssobue
 */
public class MonteCarloMethod {

  /** 繰り返し回数. */
  private static final long MAX_ITERATION = 100_000_000L;

  /** 円の範囲内とカウントされた回数. */
  private static final AtomicLong insideCircleCnt = new AtomicLong(0L);

  /** 円の範囲外とカウントされた回数. */
  private static final AtomicLong outsideCircleCnt = new AtomicLong(0L);

  /**
   * Main method.
   *
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    LongStream.range(0L, MAX_ITERATION)
        .parallel()
        .forEach(
            i -> {
              if (isInsideCircle(Math.random(), Math.random())) {
                insideCircleCnt.incrementAndGet();
              } else {
                outsideCircleCnt.incrementAndGet();
              }
            });

    // 結果表示
    System.out.println("Iteration = " + MAX_ITERATION);
    System.out.println("Inside = " + insideCircleCnt.get());
    System.out.println("Outside = " + outsideCircleCnt.get());

    System.out.println("PI = " + ((double) insideCircleCnt.get() / (double) MAX_ITERATION) * 4.0);
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
    long inside = 0L;
    for (long i = 0; i < iteration; i++) {
      if (isInsideCircle(Math.random(), Math.random())) {
        inside++;
      }
    }
    return ((double) inside / (double) iteration) * 4.0;
  }
}
