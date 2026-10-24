package com.ex14;

import com.ex01.Direction;
import com.ex01.MoveState;
import com.ex01.Piece;
import com.ex01.Point;
import java.util.HashMap;
import java.util.Set;
import static com.ex01.Massge.*;

public final class MainClass {

  private HashMap<Point, Piece> piecepath = new HashMap<>(32);
  private HashMap<Point, Set<MoveState>> board = new HashMap<>(90);

  private void setPiecePath(int[] codelist) {
  HashMap<Point,Piece> piecepath = new HashMap<>(codelist.length);
    for(int i=0; i < codelist.length; i++){
      
      
 //     piecepath.put(point,piece);
    }
  }

  private HashMap<Point, Set<MoveState>> setPieceMoveChack(HashMap<Point, Piece> path) {

    return null;
  }

  public static void main(String[] args) {
    print("Ex14 2025.05.30");
    Direction path = Direction.UP;
    print(path);
    print(path.cw());
    print(path.cw().cw());

    print(path.spin(-6));
    Point p = Point.of(4, 1);
    print("Start" + p);
    p = p.move(path);
    print(path.name() + p);
    p = p.move(path.spin(-19));
    print(path.spin(-19).name() + p);
  }
}
