package com.game2.worm;

public class StartGame {

  public static void main(String[] args) {
        
    Land land = new Land();
    land.addWorm();
    land.addWorm();
    land.addWorm();
    land.addWorm();
    land.addWorm();
    land.addWorm();
    land.addWorm();
    land.addWorm();
    land.addWorm();
    land.addWorm();
    System.out.println("게임시작");
    land.start();
  }
}
