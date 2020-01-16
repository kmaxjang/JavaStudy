package com.game.worm;

public class StartGame {

  public static void main(String[] args) {
    System.out.println("게임시작");
 
    Land land = new Land();
    land.addWorm( new Worm(Way.UP, new Point(5,5)));
    land.addWorm( new Worm(Way.DOWN, new Point(3,3)));
    
    land.start();

  }
}
