package com.ex06;

import com.ex01.Point;

public interface Move {

  public Point point();

  public String mark();

  public void chose();
  
  public boolean isChose();
}
