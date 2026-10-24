package com.ex12;

public final class LineRange {

  private final int min;
  private final int max;

  public LineRange() {
    min = 0;
    max = Integer.MAX_VALUE;
  }

  public LineRange(int min, int max) {
    // 0 <= min <= max
    this.min = Math.max(0, min);
    this.max = Math.max(this.min, max);
  }

  public int min() {
    return min;
  }

  public int max() {
    return max;
  }

  public int range(int length) {
    return Math.max(min, Math.min(max, length));
  }
}
