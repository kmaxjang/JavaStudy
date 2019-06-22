package com.exproject.pattern.observer;

import com.exproject.pattern.observer.Server;

public class Ex {

  public static void main(String[] args) {
    Server server = new Server();
    Player player1 = new Player("play1");
    Player player2 = new Player("play2");
    Player player3 = new Player("gast");
    
    player1.setServer(server);
player2.setServer(server);
player3.setServer(server);

    String[] data = {"플래이1","이동"};
    player1.play(data);
    player2.play(data);
    player1.play(data);
    player2.play(data);
    
  }
}
