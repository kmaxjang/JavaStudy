package com.ex18;

import com.ex18.Chose;
import com.ex18.Turn;
import java.util.HashMap;

public final class Board {

  private int[] board = new int[90];
private HashMap move;

  
  private Turn start =
      new Turn() {
        public void chose(int point) {
          chose.chose(point);
        }
      };
  private Turn end = new Turn(){
    public void chose(int point){}
  };
        
  private Chose one=
      new Chose() {
        public void chose(int point) {
          int piece = board[point];
          if(piece != 0){
           move = piece_move_map.get(piece);
           chose = two;
          }
        }
      };      
  private Chose two= new Chose(){
    public void chose(int point){
      if(move.containsKey(point)){
        
        turn = end;
      }else{
        
      }
    }
  };
private Turn turn = start;
private Chose chose = one;

  // key: 말좌표 velue: 이동경로,가능여부
  HashMap<Integer, HashMap<Integer, Boolean>> piece_move_map = new HashMap<>();

  private int[] default_piece_map = {
    0, 1, 1, 3, 2, 4, 3, 5, 5, 5, 6, 3, 7, 4, 8, 1, 13, 0, 19, 2, 25, 2, 27, 6, 29, 6, 31, 6, 33, 6,
    35, 6, 54, 13, 56, 13, 58, 13, 60, 13, 62, 13, 64, 9, 70, 9, 76, 7, 81, 8, 82, 10, 83, 11, 84,
    12, 86, 12, 87, 10, 88, 11, 89, 8
  };

  public void chose(int point) {
    turn.chose(point);
  }
}

interface Turn {
  public void chose(int point);
}

interface Chose {
  public void chose(int point);
}

/*
1 cho
2 han
1  2 3  4 5 6  7
왕 차 포 마 상 사 졸
좌표 0~ 90
1114150 초왕 현14좌표 구 15좌표 잡은말
2200000 한차 현0좌표 구 0좌표 잡은말

 1. chose(point);
 2. 공백 return 1
 2. piece return 3
 3. 경로표시
 4. chose(point);
 5. 공백 > 경로취소 return 1
 5. piece > 경로취소 > return 3
 5. 경로선택 > 경로취소 > 턴종료 > return 1

*/
