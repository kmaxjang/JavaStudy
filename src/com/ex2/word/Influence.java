package com.ex2.word;

import com.ex2.tool.Point;
import com.ex2.tool.Group;

public interface Influence {

  public void time();

  public boolean death();

  public Point getPoint();
  
  public Group getGroup();
  
  public String info();
}
