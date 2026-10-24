package com.exproject.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/* 대이터 차트
플래이어1 => 한
플래이어2 => 초
count
1709080 => 초 차 좌표 이동좌표 기물포획
2103130
...
2000000 => 한 한수쉼
1000000

*/
public class Recording {

  private List<String> record = new ArrayList<String>();
  private boolean update = false;
  // private int count = 0;
  private int now_point = 0;
  private int end_point = 0;

  private Player[] player = new Player[2];

  public Recording(Player player1, Player player2) {
    this.player[0] = player1;
    this.player[1] = player2;
    record.add(player1.getName());
    record.add(player2.getName());
    record.add(Integer.toString(0));
  }

  private void setCount() {
    record.set(2, Integer.toString(record.size() - 3));
  }

  public int getCount() {
    return Integer.parseInt(record.get(2));
  }

  public void record(String data) {
    record.add(data);
    setCount();
    update = true;
  }
  
  public void run(){
    int turn = 0;
    while(true){
      if(player[turn].turn()){
 //       record.add(player[turn].getPlayerInfo());
        setCount();
        turn = (turn == 0)? 1:0;
      }
    }
  }
  
  
}
