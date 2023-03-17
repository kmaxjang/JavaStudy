package com.game.janggi.ex5;

import java.util.Iterator;

import com.game.janggi.ex2.tool.Point;
import com.game.janggi.ex5.Group;

public abstract class Piece {

protected final Group group;
protected final PieceName name;
private final int code;

public Piece(Group group, PieceName name){
  this.group = group;
  this.name = name;
  this.code = group.getCode()+name.getCode();
}

  public Group getGroup(){
    return group;
  }

  public PieceName getName(){
    return name;
  }
  
  public int getCode(){
    return code;
  }

  public abstract Iterator<Point> getMoveable();

  public abstract boolean setMove(Point point);
}
