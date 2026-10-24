package com.ex01.board;

public interface MoveState {

  public void getPoint();

  public boolean isMove();

  public String getState();

  public boolean recheck();
  
}
