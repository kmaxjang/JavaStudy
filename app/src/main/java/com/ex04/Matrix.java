package com.ex04;

import com.ex01.Direction;
import com.ex01.Point;

public class Matrix {
  // matrix[][] 원본 기준
  // x,y diretcion 회전좌표
  // diretcion 회전각
  // x좌표 길이가 다를때.
  public static int rotate2(int[][] matrix, int x, int y, Direction diretction) {

    switch (diretction) {
      case UP: // 0
        {
          return (matrix[y].length <= x) ? 0 : matrix[y][x];
        }
      case LEFT: // 90
        {
          int row = matrix.length - 1 - x; // 세로 길이
          return (matrix[row].length <= y) ? 0 : matrix[row][y];
        }
      case DOWN: // 180
        {
          int row = matrix.length - 1 - y; // 세로 길이
          int col = getMaxCol(matrix) - 1 - x; // 가로 길이
          return (matrix[row].length <= col) ? 0 : matrix[row][col];
        }
      case RIGHT: // 270
        {
          int col = getMaxCol(matrix) - 1 - y; // 가로 길이
          return (matrix[x].length <= col) ? 0 : matrix[x][col];
        }
      default:
    }
    return 0;
  }
  // x좌표 길이가 같을때
  public static int rotate(int[][] matrix, int x, int y, Direction diretction) {

    switch (diretction) {
      case UP: // 0
        { // 그대로 출력
          return matrix[y][x];
        }
      case LEFT: // 90
        { // x,y 반전 y축 줄어듬
          return matrix[matrix.length - 1 - x][y];
        }
      case DOWN: // 180
        { // x,y 줄어듬
          int row = matrix.length - 1 - y; // 세로 길이
          int col = matrix[y].length - 1 - x; // 가로 길이
          return matrix[row][col];
        }
      case RIGHT: // 270
        { // x,y 반전 x축 줄어듬
          return matrix[x][matrix[y].length - 1 - y];
        }
      default:
    }
    return 0;
  }
  // x축 길이가 다를때 가장긴 길이
  public static int getMaxCol(int[][] matrix) {
    int max = 0;
    for (int[] col : matrix) {
      if (max < col.length) max = col.length;
    }
    return max;
  }

  public static Point getToUP(Direction direction, Point p, int colmax, int rowmax) {
    switch (direction) {
      case UP:
        return p;
      case LEFT:
        return Point.of(p.y, rowmax - 1 - p.x);
      case DOWN:
        return Point.of(rowmax - 1 - p.x, colmax - 1 - p.y);
      case RIGHT:
        return Point.of(colmax - 1 - p.y, p.x);
    }
    return p;
  }

  public static StringBuilder print(int[][] matrix) {
    StringBuilder sb = new StringBuilder();
    for (int y = 0; y < matrix.length; y++) {
      for (int x = 0; x < matrix[y].length; x++) {
        sb.append(String.format(" %02d", matrix[y][x]));
      }
      sb.append("\n");
    }
    return sb;
  }

  public static StringBuilder print(int[][] matrix, Direction direction) {
    StringBuilder sb = new StringBuilder();
    int col = getMaxCol(matrix);
    int[] length = getRotatoLength(matrix, direction);
    for (int y = 0; y < length[1]; y++) {
      for (int x = 0; x < length[0]; x++) {
        Point p = getRotatoPoint(x, y, length[0], length[1], direction);
        sb.append(String.format(" %02d", matrix[p.y][p.x]));
      }
      sb.append("\n");
    }
    return sb;
  }

  public static int[] getRotatoLength(int[][] matrix, Direction direction) {
    switch (direction) {
      case UP:
      case DOWN:
        return new int[] {matrix[0].length, matrix.length};
      case LEFT:
      case RIGHT:
        return new int[] {matrix.length, matrix[0].length};
    }
    return null;
  }

  public static Point getRotatoPoint(int x, int y, int row, int col, Direction rotatedirection) {
    switch (rotatedirection) {
      case UP:
        return Point.of(x, y);
      case LEFT:
        return Point.of(y, row - 1 - x);
      case DOWN:
        return Point.of(row - 1 - x, col - 1 - y);
      case RIGHT:
        return Point.of(col - 1 - y, x);
    }
    return null;
  }
}
