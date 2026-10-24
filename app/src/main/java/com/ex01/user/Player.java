package com.ex01.user;

import com.ex01.board.Board;

public interface Player extends Compete{

  String name();

  void setBoard(Board board);
  
  void setMove(int move);
  
}

interface Compete{

}