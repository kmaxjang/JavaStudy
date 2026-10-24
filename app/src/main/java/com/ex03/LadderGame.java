package com.ex03;

import com.ex03.Point;
import java.util.HashMap;

public final class LadderGame {

  private HashMap<Point, String> finishpoint = new HashMap<>();
  private HashMap<Point, Point> laddermap = new HashMap<>();

  private int player;
  private int rail_space;
  private int rung_count;

  private Point[] startpoint;
  private int startpoint_y = 0;
  private int endpoint_y = 400;

  public LadderGame(int player) {
    this.player = range(2, 10, player);
    rail_space = 70;
    rung_count = range(4, 10, 5);
    buildPoint(player);
  }

  private int range(int min, int max, int number) {
    return Math.max(min, Math.min(max, number));
  }

  private void buildPoint(int player) {
    startpoint = new Point[player];
    for (int i = 0; i < player; i++) {
      int x = i * rail_space;
      startpoint[i] = new Point(x, startpoint_y);
      Point endpoint = new Point(x, endpoint_y);
      laddermap.put(startpoint[i], endpoint);
      finishpoint.put(endpoint, "" + i);
    }
  }
  
  private void addRung(int raila, int railb, int runga, int rungb){
    
  }
  
  public String chose(int rail){
    Point start = startpoint[rail];
    Point end;
    while(true){
      end = laddermap.get(start);
      ani(start, end);
      if(finishpoint.containsKey(end)){
        break; 
      }
      start = end;
    }
    return finishpoint.get(end);
  }
  
  private void ani(Point start, Point end){
    System.out.println("이동");
  }
  
  /*
  key start1 finsh1
      start2 finsh2
      start3 finsh3
      
      Hset in 1 out 2
           in 2 out 1
     
     point = radder.start(1)      
     hset = raddermap.get(point)
     
     point[]{ps1,p1,p2,pe2}
     point[]{ps2,p2,p1,pe1}
  
  */
}

class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
