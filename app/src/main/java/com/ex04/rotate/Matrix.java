package com.ex04.rotate;

public class Matrix {

  public static int rotate(int[][] matrix, int x, int y, Compass compass) {

    switch (compass) {
      case EAST: // x > -y, y > x
        if (x >= matrix.length) return 0;
        int ylength = matrix.length - 1 - x;
        if (y >= matrix[ylength].length) return 0;
        return matrix[ylength][y];
      case WEST: // x > y, y > -x

      case SOUTH: // x > -x, y > -y

      case NORTH: // x > x, y > y
      default:
    }
    return 0;
  }
}
