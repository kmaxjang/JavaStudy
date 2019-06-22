package com.exproject.pattern.composite;

import com.exproject.pattern.composite.Board;
import com.exproject.pattern.composite.PlayData;
import com.exproject.pattern.composite.Player;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Server {

  private int turn = 1;
  private int count = 0;
  private Player[] player = new Player[2];
  private List<Player> list = new ArrayList<Player>();
  private List<String> commandlist = new ArrayList<String>();
  private Board board = new Board();

  public Server(Player player1, Player player2) {
    player[0] = player1;
    player[1] = player2;
    setPlayer();
  }

  private void setPlayer() {

    int han_masag = player[0].setBatch(true, 0);
    int cho_masag = player[1].setBatch(false, han_masag);
    board.setDefaulteBatch(han_masag, cho_masag);
    // 스래드 실행
    
  }

  public boolean addPlayer(Player player) {
    return list.add(player);
  }
  
  private PlayData updata(){
    return new PlayData(){
      public String getLastCommand(){
        return null;
      }
      
      public int getCount(){
        return count;
      }
      
      public boolean isTurn(){
        return (turn == 1)? true: false;
      }
      
      public Iterator<String> getCommandList(){
        return commandlist.iterator();
      }
      
      public Iterator<String> getNowPath(){
        return board.getPieceData();
      }
    };
  }
}
