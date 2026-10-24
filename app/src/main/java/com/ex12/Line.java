package com.ex12;

import com.ex12.LineRange;
import com.ex12.ReadableLine;

public class Line implements ReadableLine {

  private int start;
  private int length;

  private LineRange type = new LineRange();

  public Line(int start, int length) {
    this.start = start;
    this.length = type.range(length);
  }

  public void setLineRange(LineRange newtype) {
    if (newtype != null) {
      type = newtype;
      length = type.range(length);
    }
  }

  @Override
  public int min() {
    return type.min();
  }

  @Override
  public int max() {
    return type.max();
  }

  public void setStart(int point) {
    start = point;
  }

  @Override
  public int start() {
    return start;
  }

  public void setLength(int length) {
    this.length = type.range(length);
  }

  @Override
  public int length() {
    return length;
  }

  @Override
  public int end() {
    return start + length;
  }

  public boolean colliding(ReadableLine other) {
    return this.start < other.end() && end() > other.start();
  }

  @Override
  public String toString() {
    return "Line Start:" + start + " Length:" + length;
  }
}
