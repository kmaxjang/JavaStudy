package com.ex20;

import java.util.Map;

import com.ex01.Group;
import com.ex01.Point;
import com.ex01.Piece;

public interface Board {

Group nowTurn();
int count();
Map<Point, Piece> getPieceAllPosition();
Point lastMove();


boolean isPiece(Point point);
Piece getPiece(Point point);

boolean command();

}
