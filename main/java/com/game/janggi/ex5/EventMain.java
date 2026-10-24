package com.game.janggi.ex5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.game.janggi.ex2.tool.Point;

public class EventMain {

  public static void msg(String msg) {
    System.out.println(msg);
  }

  private Group group = Group.Han;
  private Board board = new Board(group, new HashMap<Integer, Integer>(), new ArrayList<Integer>());
  private Piece choosepiece = null;

  public void choose(Point point) {
    if (board.isTurn() == group) {
      if (choosepiece != null) {
        screenRemoveMark();
        if (choosepiece.setMove(point)) {
          choosepiece = null;
          return;
        }
      }
      Piece piece = board.getPiece(point);
      if (piece != null && piece.getGroup() == group) {
        screenMoveableMark(piece.getMoveable());
        choosepiece = piece;
      }
    }
  }

  public void screenRemoveMark() {}

  public void screenMoveableMark(Iterator<Point> moveable) {}

  public static void main(String[] args) {
    msg("이벤트 연습");

    int size = 500;
    int row = 10;
    int min = 10;
    int cell = (size - (min * 2)) / row;

    int mousex = cell * row + min;
    int putx;
    putx = (mousex - min) / cell;
    msg("cell size " + cell);
    msg("row point " + (mousex - min));
    msg("out " + putx);
    
    Screen screen= new Screen();
    screen.background();
    screen.updata();
  }
}
