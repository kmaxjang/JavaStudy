package com.game.janggi.ex5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.game.janggi.ex2.tool.Point;

public class Board {

  private Group turn;
  private HashMap<Integer, Integer> piece_path;
  private ArrayList<Integer> history;

  public Board(Group turn, HashMap<Integer, Integer> board, ArrayList<Integer> history) {
    this.turn = turn;
    this.piece_path = new HashMap(board);
    this.history = new ArrayList(history);
  }

  public Group isTurn() {
    return turn;
  }

  public HashMap<Integer, Integer> getNowPiece() {
    return (HashMap<Integer, Integer>) piece_path.clone();
  }

  public Point getLastPoint() {
    return null;
  }

  public Piece getPiece(Point point) {
    if (piece_path.containsKey(point.toString())) {
      return null;
    }

    return null;
  }

  public int getCount() {
    return history.size();
  }

  public Iterator<Integer> getHistory() {
    return history.iterator();
  }
}
