package com.game.worm;

import com.game.worm.Scheduler;


public class StartGame {

  public static void main(String[] args) {
    System.out.println("게임시작");
    Scheduler sch = new Scheduler();
    Land land = new Land();
    sch.add(land);
    Worm worm = new Worm(10, Way.UP);
    sch.add(worm);
    sch.run();
  }
}
