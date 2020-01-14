package com.ex.word;

import com.ex.word.Data;
import com.ex.word.Players;
import com.ex.ExMain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class BattleRoom {

  private Players fighter[] = new Players[2];
  private Thread play = null;
  private List<Players> guast = new ArrayList<Players>();
  
  private List<Integer> record = new ArrayList<Integer>();
  
private long player1time = 5*60*1000;
private long player2time = 5*60*1000;
private boolean turn = true;

  public BattleRoom(Players p1, Players p2) {
    fighter[0] = p1;
    fighter[1] = p2;
    play();
  }

private Data getData(){
 return new Data(){
    public long getPlayer1Time(){
      return player1time;
    }
    
    public long getPlayer2Time(){
      return player2time;
    }
    
    public Integer getLastTurn(){
      return record.get(record.size());
    }
    
    public int getCount(){
      return record.size();
    }
    
    public Iterator<Integer> getRecord(){
      return record.iterator();
    }
    
    public boolean isPlayTurn(){
      return turn;
    }
  };
}
  private void play() {
  ExMain.scr(fighter[0].getName() +" vs "+ fighter[1].getName());
  fighter[0].setTeam(true);
  fighter[1].setTeam(!fighter[0].getTeam());
    if (play == null) {
      play =
          new Thread(
              new Runnable() {
                public void run() {
                Integer tmp =0;
                  while(true){
                  try{
                  Thread.sleep(1000);
                  }catch (Exception e){
                    
                  }
                  //타이머 초당 업대이트
                    if(turn){
                      player1time -= 1000l;
                      ExMain.scr(" "+player1time);
                      tmp = fighter[0].updata();
                    if(tmp != null){
                    record.add(tmp);
                      updata();
                      turn = false;
                    }
                    }else{
                      player2time -= 1000l;
                    }
                  }
                }
              });
     }         
      play.start();
  }

  public void joinGuast(Players p) {
    guast.add(p);
  }

  private void updata() {
      fighter[1].load(getData());
      for (Players p : guast) {
        p.load(getData());
      }
  }
  
}
