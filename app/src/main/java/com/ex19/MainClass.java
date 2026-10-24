package com.ex19;

import com.ex01.Group;
import com.ex01.Piece;
import com.ex01.PieceType;
import com.ex01.Point;
import com.ex19.Board;
import com.ex19.ComGiveUpGame;
import com.ex19.ComMove;
import com.ex19.ComPass;
import com.ex19.Command;
import static com.ex01.Massge.*;

public final class MainClass {

  public static void main(String[] args) {
    print("Java 2026.01.12");

    Board board = new Board();

    Command com3 =
        new ComMove() {
          public Piece getPiece() {
            return Piece.Han_Cha;
          }

          public Point getMovePoint() {
            return Point.of(1, 1);
          }
        };
    Command com2 = new ComPass() {};
    Command com1 = new ComGiveUpGame() {};

    board.Command(com1);
    board.Command(com2);
    board.Command(com3);
  }
}
