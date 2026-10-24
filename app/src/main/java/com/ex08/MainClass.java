package com.ex08;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
사다리 게임 규칙
사선이 플레이 수만큼 있다.
분기선은 중복되지 않는다.
시작은 사선하나중 위에서 시작한다.
1.사선 아래로 내려간다.
2.분기점을 만나면 가로 선을 따라간다.
3.사선을 만나면 아래로 내려간다.
4. 2,3을 반복한다.
5.사선밑에 도착하면 결과확인 끝
기본
분기선은 좌우하나로만 분기한다.
변칙
분기선은 어디로든 분기한다.
*/
public class MainClass {

  public Pattern search = Pattern.compile("\\X");
  public Matcher piece = search.matcher("");
String screenmark = "🔴🟠🟡🟢🔵🟣🟤🟥🟧🟨🟩🟦🟪🟫⬜️⬛🔲⭕️🚫✅️☑️0️⃣1️⃣2️⃣3️⃣4️⃣5️⃣6️⃣7️⃣8️⃣9️⃣\n";
  private HashMap<Integer, String> img_map = new HashMap<>();
  {
    int[] key = {
      11, 12, 13, 14, 15, 16, 17, 21, 22, 23, 24, 25, 26, 27, 98, 99, 97, 96, 95, 94, 93, 0, 1, 2,
      3, 4, 5, 6, 7, 8, 9, 100
    };
    
    int start = 0;
    piece.reset(screenmark);
    for (int a = 0; a < key.length; a++) {
      piece.find();
      img_map.put(key[a], screenmark.substring(start, piece.end()));
      start = piece.end();
    }
  }

  public StringBuilder board = new StringBuilder();

  public void setBoard() {
    for (int y = 0; y < 10; y++) {
      for (int x = 0; x < 9; x++) {
        board.append(img_map.get(98));
      }
      //      board.append(img_map.get(100));
    }
  }

  public StringBuilder screen = new StringBuilder();

  public void background() {
    for (int y = 0; y < 16; y++) {
      for (int x = 0; x < 11; x++) {
        screen.append(img_map.get(x % 10));
      }
      screen.append(img_map.get(100));
    }
  }

  public void player() {
    Matcher mark = search.matcher(screenmark);
    int point = 0;
    int count = 0;
    while (mark.find()) {
      msg(mark.group());
      msg("count" + count + "p" + point + "-" + mark.end());
      point = mark.end();
      count++;
    }
    msg();
    //  screen.insert(12,img_map.get(94));
    //    screen.insert(157, img_map.get(93));
        screen.replace(37, 40, img_map.get(94));
    int p = 104,p2=131;
    for(int i=0;i < 10; i++){
    screen.replace(p, p2, board.substring(i*18, (i+1)*18));
    p+=25;
    p2+=25;
    }
  }

  public String replace(int mark) {
    if (!img_map.containsKey(mark)) {
      return img_map.get(99);
    }
    return img_map.get(mark);
  }

  private static StringBuilder sb = new StringBuilder();

  public static void msg() {
    sb.append("\n");
  }

  public static void msg(String msg) {
    sb.append(msg);
  }

  public static void msgPrint() {
    System.out.println(sb.toString());
    sb.setLength(0);
  }

  public static void main(String[] args) {
    msg("Java ex08 2025.01.21");
    msgPrint();
    MainClass mc = new MainClass();
    msg(mc.replace(98));
    msgPrint();
    msg(mc.replace(108));
    int[] piecedata = {
      1200, 1401, 1502, 1603, 1605, 1506, 1407, 1208, 1114, 1321, 1327, 1730, 1732, 1734, 1736, 1738
    };
    int x, y;
    int piece;
    for (int a = 0; a < piecedata.length; a++) {
      x = (piecedata[a] / 10) % 10;
      y = piecedata[a] % 10;
      piece = piecedata[a] / 100;
      msg("X" + x + "y" + y + " Piece" + piece);
      msg(mc.replace(piece));
      msg();
    }
    msgPrint();
    mc.setBoard();
    msg(mc.board.toString());
    msg();
    //    msgPrint();
    mc.background();
    mc.player();
    msg(mc.screen.toString());
    msgPrint();
  }
}
