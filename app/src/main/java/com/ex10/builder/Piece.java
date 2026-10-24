package com.ex10.builder;

import com.ex11.Point;
import com.ex11.Move;
import java.util.HashMap;

public interface Piece {

  public String getGroup();

  public String getPiece();
  
  public HashMap<Point, Move> move();
  
}
