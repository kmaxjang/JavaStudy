package com.exproject.janggi.interfacemod;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.util.Point;

public interface PieceMove {

  public Iterator<Point> movable(Piece piece);
}
