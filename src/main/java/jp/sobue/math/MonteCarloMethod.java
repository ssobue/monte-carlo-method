package jp.sobue.math;

import java.util.stream.LongStream;

/**
 * モンテカルロ法で円周率を出す.
 *
 * @author ssobue
 */
public class MonteCarloMethod {

  /** 繰り返し回数. */
  private static final long MAX_ITERATION = 10_000_000_000L;

  /** 円の範囲内とカウントされた回数. */
  private static long insideCircleCnt = 0L;

  /** 円の範囲外とカウントされた回数. */
  private static long outsideCircleCnt = 0L;

  /**
   * Main method.
   *
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    LongStream.range(0L, MAX_ITERATION)
        .forEach(
            i -> {
              if (isInsideCircle(Math.random(), Math.random())) {
                insideCircleCnt++;
              } else {
                outsideCircleCnt++;
              }
            });

    // 結果表示
    System.out.println("Iteration = " + MAX_ITERATION);
    System.out.println("Inside = " + insideCircleCnt);
    System.out.println("Outside = " + outsideCircleCnt);

    System.out.println("PI = " + ((double) insideCircleCnt / (double) MAX_ITERATION) * 4.0);
  }

  /**
   * 座標(x,y)が円の範囲内判定する.
   *
   * @param x x-value
   * @param y y-value
   * @return 円の範囲内か
   */
  private static boolean isInsideCircle(double x, double y) {
    // √(x^2 + y^2)が1以下
    return Math.sqrt((x * x) + (y * y)) <= 1.0;
  }
}
