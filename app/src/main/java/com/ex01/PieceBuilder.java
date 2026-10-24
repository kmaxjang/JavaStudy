package com.ex01;

import com.ex01.Piece;
import com.ex01.PieceType;
import com.ex01.Point;
import com.ex01.SangPath;
import java.util.HashMap;
import static com.ex01.Massge.*;

public final class PieceBuilder {

/*  private String[] regex = {
    "(?i)^(Data|날짜): \\d{4}-\\d{2}-\\d{2}$",
    "(?i)^(PiecePath|장기알 위치): ((default|기본)(?:\\{[0-3],[0-3]\\}))|\\{(\\d{4}(,\\d{4})*)\\}$",
    "^\\{([1-2][1-7][0-8][0-9])(,([1-2][1-7][0-8][0-9])*)\\}$",
    "^(History|기록):\n(([1-9]|[1-9][0-9]|1[0-9][0-9]|200) (한|초)((왕|차|포|마|상|사|졸)[0-8][0-9][0-8][0-9](?:차|포|마|상|사|졸)|(한수쉼|기권패|시간패|점수패|외통패|접속끈김))\n){1,200}$"
  };
*/  
  private static final int[] default_piece_poition = {  
    1010,1020,1060,1070, // HAN 상차림
    2019,2029,2069,2079, // CHO 상차림
      1600, 1230, 1250, 1680,
      1741,
      1512, 1572, 
      1103, 1123, 1143, 1163, 1183,
      2106, 2126, 2146, 2166, 2186,
      2517, 2577, 
      2748, 
      2609, 2239, 2259, 2689
    };
  
  public static void defaultPiecePoition(SangPath han, SangPath cho){
  int i=0;
    PieceType[] piece = han.layout;
    for(PieceType PieceType: piece){
    default_piece_poition[i]+=(PieceType.code()*100);
    i++;
    }
    piece = cho.layout;
    for(PieceType PieceType: piece){
    default_piece_poition[i]+=(PieceType.code()*100);
    i++;
    }
    for(int a: default_piece_poition)
    print(a);
  }

//  private HashMap<Point, Piece> map = new HashMap<>();

  public void setBuilder(int data) {}

  public HashMap<Point, Piece> getBuilder() {

    return null;
  }
  
  public static int digitAt(int code, int position) {
    return digitAt(code, position, 1);
  }

  public static int digitAt(int code, int position, int length) {
    int divisor = (int) Math.pow(10, digitCount(code) - position);
    int divisor2 = (int) Math.pow(10, length);
    return (code / divisor) % divisor2;
  }

  public static int digitCount(int number) {
    if (number == 0) return 1;
    return (int) Math.log10(number) + 1;
  }
  
  public static void main(String[] args){
     PieceBuilder.defaultPiecePoition(SangPath.MSMS,SangPath.MSSM);
     
     Group group;
    PieceType piecetype;
    int code = 1100;
    print("Code:"+code);
    print(String.valueOf(code).charAt(0));
    print(Group.of(digitAt(code,1)));
    group = Group.of(digitAt(code,1));
    piecetype = PieceType.of(digitAt(code,2));
    print(piecetype == null);

    print(group);
  }
}

/*
group 1한 2초
PieceType 1왕 2차 3포 4마 5상 6사 7졸
point code 0~90 x0~8 y0~9
command 0
00000 한수쉼
10000 기권

4자리
1 group
2 PieceType
3 point x
4 point y

7자리
1 group
2 PieceType
3 point x
4 point y
5 oldpoint x
6 oldpoint y
7 killpiece 0-7

기록
날짜 시간
player[한, 초]
piecepath {4자리, ...} default(4,5)
1 초말 현위치 전위치 잡은말
3 한말 현위치 전위치 잡은말
...
결과 50/200수 한 외통승

*/
