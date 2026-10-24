package com.ex19;

import com.ex01.Piece;
import com.ex01.Point;
import com.ex19.Command;

public interface ComMove extends Command {

  Piece getPiece();

  Point getMovePoint();
}
