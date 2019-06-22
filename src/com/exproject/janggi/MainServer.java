package com.exproject.janggi;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class MainServer {

  private Thread t;
  private List<Player> players = new ArrayList<Player>();
  private List<GamePlay> gameplay = new ArrayList<GamePlay>();

  public MainServer() {
    t =
        new Thread(
            new Runnable() {
              public void run() {
                System.out.println("메인서버 시작");
                while (true) {
                  try {

                    Thread.sleep(10);
                  } catch (Exception e) {

                  }
                }
                // System.out.println("메인서버 종료");
              }
            });
    t.start();
  }

  public void join(Player player) {
    players.add(player);
  }
  
  public void logout(Player player){
    players.remove(player);
  }

  private void createGamePlay(Player p1, Player p2) {
    //
  }
  
  public Iterator<String> getPlayersList(){
    return null;
  }
  
  public Iterator<String> getGamePlayList(){
    return null;
  }
  
  public boolean joinGamePlay(String gameplayname, Player guest){
    
    return false;
  }
  
}
