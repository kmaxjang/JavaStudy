package com.game.janggi.ex.interfacemod;

import java.util.Iterator;

import com.game.janggi.ex.ex1.Board;
import com.game.janggi.ex.util.Point;

public interface PieceMove {

  public Iterator<Point> moveable(Board board, Piece piece);
}
