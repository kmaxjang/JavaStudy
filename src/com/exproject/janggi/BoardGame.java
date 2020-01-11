package com.exproject.janggi;

import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.interfacemod.Piece.Team;
import com.exproject.janggi.util.Point;

public class BoardGame {

  public String background_mark = "🌑";
  public String movable_mark = "💢";

  public String[][] board = new String[9][10];

  private GameRule gr;
  private Board bd;
  private boolean turn = false;
  private boolean choice = false;
  private Piece piece = null;

  public BoardGame() {
    gr = new GameRule();
    gr.setDefaultPieceSet();
    gr.setMaSagPosition(true, 4);
    gr.setMaSagPosition(false, 1);

    bd = gr.getBoard();
  }

  public void play(Point p) {

    if (choice) {
      if (bd.setMove(piece, p)) {
        turn = !turn;
      }
      choice = false;
      display(null);
      return;
    }
    
    piece = bd.getPiece(p);
    if (piece != null && piece.getTeam() == Team.CHO) {
      display(piece);
      choice = true;
    }
  }

  public void display(Piece p) {
    clear();
    marker();
    if (p != null) marker2(p);
    System.out.println(" 0 1 2 3 4 5 6 7 8 ");
    for (int y = 0; y < board[0].length; y++) {
      System.out.print(y);
      for (int x = 0; x < board.length; x++) {
        System.out.print(board[x][y]);
      }
      System.out.println("");
    }
    System.out.println("");
  }

  public void marker() {
    Piece piece;
    Iterator<Piece> i = bd.getPieceList();
    while (i.hasNext()) {
      piece = i.next();
      board[piece.getPosition().x][piece.getPosition().x] = piece.getClassName().number;
    }
  }

  public void marker2(Piece piece) {
    Point p;
    Iterator<Point> i = piece.movable();
    while (i.hasNext()) {
      p = i.next();
      board[p.x][p.x] = movable_mark;
    }
  }

  public void clear() {
    for (int x = 0; x < board.length; x++) {
      for (int y = 0; y < board[x].length; y++) {
        board[x][y] = background_mark;
      }
    }
  }

  boolean timer_turn = true;
  int count = 0;
  int count2 = 0;
    Timer timer = new Timer();
    TimerTask tt = new TimerTask(){
      
      public void run(){
        System.out.println("5분됐닄1�7"+ timer_turn +" "+count+" "+ count2);
      //  timer_turn =(timer_turn)? false: true;
        if(timer_turn){
          count++;
        }else{
          count2++;
        }
     //   this.cancel();
      }
    };
    
    public void timerStart(){
    System.out.println("탄1�7이머 작동");
    timer.schedule(tt,0,1000);
     
  System.out.println(timer.purge());
    while(count < 30){
      
    }
    timer.cancel();
//    timer.schedule(tt,1000*20);
    System.out.println("시스템종룄1�7");
    
    }
    
  public static void main(String[] arg) {

    BoardGame bg = new BoardGame();
    Point pp = new Point(0,6);

    bg.play(pp);
    pp.set(1,6);
    bg.play(pp);

    pp.set(0,3);
    bg.play(pp);
    pp.set(1,3);
    bg.play(pp);

    pp.set(0,9);
    bg.play(pp);
    pp.set(0,0);
    bg.play(pp);
    
    pp.set(1,2);
    bg.play(pp);
    pp.set(1,6);
    bg.play(pp);
    
    pp.set(0,3);
    bg.play(pp);
    pp.set(1,3);
    bg.play(pp);  
    
    pp.set(0,0);
    bg.play(pp);
    pp.set(0,1);
    bg.play(pp);
    

 // bg.timerStart();
  }
}
