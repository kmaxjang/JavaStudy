package com.ex01;

import com.ex01.Group;
import com.ex01.Piece;
import java.util.HashMap;
import java.util.Map;
import static com.ex01.PieceType.*;

public enum SangPath {
  MSMS(MA, SANG, MA, SANG),
  MSSM(MA, SANG, SANG, MA),
  SMMS(SANG, MA, MA, SANG),
  SMSM(SANG, MA, SANG, MA);

  public final PieceType[] layout;

  private SangPath(PieceType... layout) {
    this.layout = layout;
  }

  public void apply(Group group, Map<Point, Piece> piece_map) {
    int p = (group == Group.HAN) ? 0 : 9;
    piece_map.put(Point.of(1, p), Piece.of(group, layout[0]));
    piece_map.put(Point.of(2, p), Piece.of(group, layout[1]));
    piece_map.put(Point.of(6, p), Piece.of(group, layout[2]));
    piece_map.put(Point.of(7, p), Piece.of(group, layout[3]));
  }
}
