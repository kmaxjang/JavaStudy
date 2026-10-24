package com.ex20;

import java.util.Map;
import java.util.List;

import com.ex01.Group;
import com.ex01.user.Player;
import com.ex01.Point;
import com.ex01.Piece;

public class GameRoom {

  private Group turn = Group.CHO;
  private Map<Point, Piece> piecemap;
  private Player[] player = new Player[2];
  private List<Player> spectatorlist;
  
  public GameRoom(Player han, Player cho, Map<Point,Piece> piecemap){
    player[1] = han;
    player[0] = cho;
    this.piecemap = piecemap;
    
    han.setBoard(null);
    cho.setBoard(null);
  }
  
  private void move(Point p, Point mp){
    Piece piece = piecemap.get(p);
    if(piece != null && piece.group() == turn){
      piecemap.remove(p);
      piecemap.put(mp,piece);
      turn();
      alarm();
    }    
  }
  
  private void turn(){
    turn =(turn != Group.CHO)? Group.CHO: Group.HAN;
  }
  
  private void alarm(){
    player[turn.code()].setMove(0);
   
    if(!spectatorlist.isEmpty()){
      for(Player player: spectatorlist){
        //전달
        player.setMove(0);
      }
    }
  }
  
}
