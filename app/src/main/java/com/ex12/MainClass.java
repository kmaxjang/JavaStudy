package com.ex12;

import com.ex12.Line;
import com.ex12.LineRange;

public final class MainClass {

  public static void main(String[] args) {
    Line line = new Line(100, 10);
    Line line2 = new Line(5, 10);
    LineRange range = new LineRange(3,5);
    line.setLineRange(range);
    line2.setLineRange(range);
    System.out.println(line.colliding(line2));
    System.out.println(line);
    System.out.println(line2);
  }
}
