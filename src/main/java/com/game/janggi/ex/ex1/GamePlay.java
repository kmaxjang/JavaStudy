package com.game.janggi.ex.ex1;

import java.util.ArrayList;
import java.util.List;

import com.game.janggi.ex.interfacemod.Play;

public class GamePlay {

  private List<Player> playerlist = new ArrayList<Player>(); // 플래이어와 관중
  private List<String> record = new ArrayList<String>(); // 수순
  private List<String> now_path = new ArrayList<String>(); // 현재배치

  private boolean turn = false; // turn == team
  private Board board = new Board();

  public GamePlay(Player player1, Player player2) {
    playerlist.add(player1);
    playerlist.add(player2);

    String masan1 = player1.setGamePlay(null, getPlay(true, player1));
    String masan2 = player2.setGamePlay(masan1, getPlay(false, player2));

    setDefaultPath(masan1, masan2);
  }

  private void setDefaultPath(String p1, String p2) {
    // now_path;
  
  }

  private void record(String path) {
    record.add(path);
    // now_path
  }

  private Play getPlay(final boolean team, Player player) {
    return new Play() {
      public boolean turnEnd(String path) {
        if (turn == team) {
          record(path);
          turn = turn ? false : true;
          for (Player itr : playerlist) {
            itr.updata(path);
          }
          return true;
        }
        return false;
      }

      public String gameover() {
        return null;
      }

      public boolean turn() {
        return turn;
      }

      public String getTime() {
        return null;
      }

      public boolean team() {
        return team;
      }
    };
  }

  public boolean addViewers(Player viewers) {
    // 		viewers.setPath(now_path);
    // 		viewers.setRecord(record);
    return playerlist.add(viewers);
  }

  public boolean removeViewers(Player viewers) {
    return playerlist.remove(viewers);
  }

  private boolean setTime(String time) {
    return true;
  }

  private int turn() {
    return turn ? 1 : 2;
  }
}
