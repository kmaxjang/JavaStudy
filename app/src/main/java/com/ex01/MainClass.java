package com.ex01;

import com.ex01.Board;
import com.ex01.Config;
import com.ex01.Group;
import com.ex01.Piece;
import com.ex01.PiecePath;
import com.ex01.PieceType;
import com.ex01.board.TimeService;
import com.ex01.board.Turn;
import com.ex01.board.TurnTimer;
import com.ex01.user.AbstractPlayer;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.ex01.Massge.*;

public final class MainClass {

  public static void main(String[] args) {
    print("Java EX01 2024.08.02");

    // 플레이어 생성
    print(AbstractPlayer.of("player1"));
    //   msg(AbstractPlayer.of("player1").name());
    // 룸 등록
    Piece piece = Piece.Han_King;
    Piece piece2 = Piece.Cho_King;
    print(piece.isType(piece));;
    Piece piece3 = Piece.Cho_King;
    print(piece.isType(piece));
    print(piece.isType(piece2));
    print(piece.isType(piece3));

    print(0 % 5);
    print(null == Piece.Han_Cha);
    Group group = Group.HAN;
    PieceType type = PieceType.KING;
    Piece king = Piece.of(group, type);

    print(group);
    print(type);
    print(king);

    Point kingpoint = Point.of(3, 2);
    print(kingpoint);
    Board board = new Board(PiecePath.defaultBuild(SangPath.MSMS, SangPath.SMMS));

    board.chackmate(kingpoint, king);
    board.chackmate(Point.of(4, 8), Piece.Cho_King);
    Map<Point, String> path = board.getPiecePath();

    for (Point p : path.keySet()) {
      print(p + " " + path.get(p));
    }

    String mark = Config.Tile_Number.value();
    print(mark);

    Pattern search = Pattern.compile("\\X"); // 유니코드 문자단위 필터
    Matcher matcher = search.matcher(mark);
    StringBuilder sb = new StringBuilder();
    int count = 0;
    while (matcher.find()) {
      String ch = matcher.group();
      count++;
      print(ch.length() + " " + ch);
      sb.append(ch);
    }

    print(sb);

    /*
    HashMap<Point, String> map = board.getPath();
    Piece piece = board.getPiece();
    HashMap<Point, boolean> move = piece.moveable();


    piece.move(point);

    */
    // 정규식 표현 . 아무문자 {4}반복 ()그룹설정 $1그룹 불러오기

    long[] num = {0L, 0L};

    int[][] p = {
      {44, 43, 42, 41, 39, 38, 37, 36, 31, 25, 19, 17, 15, 13, 11, 9},
      {0, 1, 2, 3, 5, 6, 7, 8, 13, 19, 25, 27, 29, 31, 33, 35}
    };

    for (int x = 0; x < p.length; x++)
      for (int i = 0; i < p[x].length; i++) {
        num[x] = num[x] | (1L << p[x][i]);
      }

    print("Number " + num[0]);
    print("Number " + num[1]);
    print(
        String.format("%45s%45s", Long.toBinaryString(num[0]), Long.toBinaryString(num[1]))
            .replace(' ', '0')
            .replaceAll("(.{9})", "$1\n"));

    /*
        public static String toBinary32(int n) {
     String s = String.format("%32s",
      Integer.toBinaryString(n))
      .replace(' ', '0');

     return s.replaceAll("(.{8})", "$1 ");
    }
    */

    TimeService ts = new TimeService(90, 90, 1);
    TurnTimer a, b;
    a =
        new TurnTimer() {
          public void setTurn(Turn turn) {
            try {
              Thread.sleep(5000);
             turn.endTurn();
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
          }

          public void setTimeMessage(boolean turn, int time, int chancecount) {
            print("" + turn + "time" + time + " count" + chancecount);
          }
        };
    b =
        new TurnTimer() {
          public void setTurn(Turn turn) {
            try {
              Thread.sleep(1000);
             turn.endTurn();
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
          }

          public void setTimeMessage(boolean turn, int time, int chancecount) {
            // print("" + turn + time + chancecount);
          }
        };
    ts.start(Group.CHO, b, a);
    
    print("종료");
  }
}

/*
장기배치
이동장기 선택 > 이동가능 표시 > 이동가능 외 선택시 > 취소
                       > 가능 선택시 > 이동 > 턴종료
board.getNowPath() HashMap<Point, Piece>
board.getPiece(Point p) Piece
piece.moveable() HashMap<Point, Boolean>
piece.move(Point mp) boolean


*/
