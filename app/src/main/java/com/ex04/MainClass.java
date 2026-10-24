package com.ex04;

import com.ex01.Direction;
import com.ex01.Group;
import com.ex01.PieceType;
import com.ex01.Point;
import com.ex04.Matrix;
import com.ex04.Piece;
import java.util.HashMap;
import static com.ex01.Massge.*;

public final class MainClass {

  public static void main(String[] args) {
    HashMap<Piece, String> map = new HashMap<>();
    Piece p1 = new Piece(Group.HAN,PieceType.POO, Point.of(1, 2));
    Piece p2 = new Piece(Group.CHO, PieceType.CHA, Point.of(0, 0));
    print(p1.equals(p2));
    map.put(p2, "차 입력");
    map.put(p1, "2차 입력");
    print(map.get(p1));
    print(map.get(p1));
    print(2 * Math.pow(10, 1) + (7 * Math.pow(10, 0)));
    int count = 0, d = 0;
    while (true) {
      print(d = (d + 4) % 5);
      if (count > 100) {
        break;
      } else {
        count++;
      }
    }

    // 1 getChoose(Point p);
    // 2 자신의 말인가? y3 n1
    // 3 이동표시
    // 4 getChoose(Point p)
    // 5 이동가능인가? y7 n6
    // 6 이동표시 지우고 1
    // 7 이동표시 지우고 턴종료
    /*
       int[][] matrix = new int[4][4];
       count = 0;
       for (int x = 0; x < matrix.length; x++) {
         for (int y = 0; y < matrix[x].length; y++) {
           matrix[x][y] = count;
           count++;
         }
       }
    //*/

    int[][] matrix = {
      {11, 12, 13, 14, 15}, //
      {21, 22, 23, 24, 25}, //
      {31, 32, 33, 34, 35}, //
      {41, 42, 43, 44, 45},
      {51, 52, 53, 54, 55},
      {61, 62, 63, 64, 65},
      {71, 72, 73, 74, 75}
    };
    print("기본 배열");
    print(Matrix.print(matrix));

    int colmaxlength = Matrix.getMaxCol(matrix);

    print("Up0[" + matrix.length + "][" + colmaxlength + "]\n");
    int[][] matrixup = new int[matrix.length][matrix[0].length];
    for (int y = 0; y < matrixup.length; y++) {
      for (int x = 0; x < matrixup[y].length; x++) {
        matrixup[y][x] = Matrix.rotate(matrix, x, y, Direction.UP);
      }
    }
    print(Matrix.print(matrixup));

    print("LEFT[" + matrix.length + "][" + colmaxlength + "]\n");
    int[][] matrixleft = new int[matrix[0].length][matrix.length];
    for (int y = 0; y < matrixleft.length; y++) {
      for (int x = 0; x < matrixleft[y].length; x++) {
        matrixleft[y][x] = Matrix.rotate(matrix, x, y, Direction.LEFT);
      }
    }
    print(Matrix.print(matrixleft));

    print("DOWN[" + matrix.length + "][" + colmaxlength + "]\n");
    int[][] matrixdown = new int[matrix.length][matrix[0].length];
    for (int y = 0; y < matrixdown.length; y++) {
      for (int x = 0; x < matrixdown[y].length; x++) {
        matrixdown[y][x] = Matrix.rotate(matrix, x, y, Direction.DOWN);
      }
    }
    print(Matrix.print(matrixdown));

    print("RIGHT[" + matrix.length + "][" + colmaxlength + "]\n");
    int[][] matrixright = new int[matrix[0].length][matrix.length];
    for (int y = 0; y < matrixright.length; y++) {
      for (int x = 0; x < matrixright[y].length; x++) {
        matrixright[y][x] = Matrix.rotate(matrix, x, y, Direction.RIGHT);
      }
    }
    print(Matrix.print(matrixright));

    count = 0;
    for (int y = 0; y < matrix.length; y++) {
      for (int x = 0; x < matrix[0].length; x++) {
        Point p =
            Matrix.getToUP(Direction.RIGHT, Point.of(x, y), matrix.length, matrix[0].length);
         print(String.format("lift[%d][%d] %d == %d matrix[%d][%d]",y,x,matrix[y][x],matrix[p.y][p.x],p.y,p.x));   
        if (matrix[y][x] == matrix[p.y][p.x]) {
          count++;
        }
      }
    }
    print(count);
    /*
    private static boolean root = true;

    public static Move getMoveMarker(final String marks, final boolean moves) {
      return new Move() {
        private boolean move = moves;
        private String mark = marks;

        public void choose() {
          if (move) {
            // 좌표전송
            root = false;
            move = false;
          }
        }

        public String marker() {
          return mark;
        }

        public boolean isChoose() {
          return root ? move : root;
        }
      };
    }
    */
  }
}
