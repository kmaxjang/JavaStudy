package com.ex2.tool;

public final class Point {

public int x = 0;
public int y = 0;

public Point(){
  x = 0;
  y = 0;
}

public Point(int x, int y){
  this.x = x;
  this.y = y;
}

public Point(Point p){
  this.x = p.x;
  this.y = p.y;
}

public void move(int mx, int my){
  x += mx;
  y += my;
}

public void move(Point mp){
  move(mp.x, mp.y);
}

}
