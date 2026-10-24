package com.ex01.board;

public interface TurnTimer {
  void setTurn(Turn turn);

  void setTimeMessage(boolean turn, int time, int chancecount);
}
