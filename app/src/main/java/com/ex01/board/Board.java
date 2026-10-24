package com.ex01.board;

import java.util.List;
import com.ex01.piece.PieceMark;
import com.ex01.Group;
import com.ex01.Piece;
import com.ex01.Point;
import com.ex01.Record;
import com.ex01.board.Board;

public interface Board {

  int turnCount();

  Group nowTurn();

  String[] playerInfo();

  Iterable<PieceMark> getPiecePath();

  Piece getPiece(Point point);

  Board getVirtualBoard();

  Record getHistory();
}
