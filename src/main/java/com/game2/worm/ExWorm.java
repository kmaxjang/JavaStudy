package com.game2.worm;

import java.util.LinkedList;
import java.util.List;

public class ExWorm {

  public static void main(String[] args) {
    LinkedList<Point> worm = new LinkedList<>();
    Point size = new Point(10,10);
    
    for(int x=0;x< size.x; x++)
    for(int y=0;y< size.y; y++)
    worm.add(new Point(x, y));
    
    worm.removeLast();
    worm.addFirst(new Point(0,0));
    
    for(Point p: worm){
      p.move(1,1);
    }
    
    StringBuffer sb = new StringBuffer(10*10*5);
    for(Point p: worm){
      sb.append(p);
    }
    System.out.println(sb);
  }
}
