package com.ex;

import com.ex.user.Computer;
import com.ex.user.Player;
import com.ex.word.BattleRoom;
import com.ex.word.Players;

public class ExMain {
  // 화면출력
  public static void scr(String str) {
    System.out.println(str);
  }

  public static void main(String[] args) {
    scr("안녕 자바");
    Players p1,p2;
    p1 = new Computer();
    p2 = new Player("Player1");
    
    BattleRoom br = new BattleRoom(p1,p2);
try{
  Thread.sleep(5000);
}catch (Exception e){
  
}    
scr("프로그램 종료");
  }
}
