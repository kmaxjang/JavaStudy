package com.ex01;

import java.util.HashMap;
import com.ex01.Point;
import com.ex01.Board;

public interface Moveable {

  HashMap<Point, Boolean> move(Point from, Board board);
}
