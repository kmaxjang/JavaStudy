package com.exproject.pattern.composite;

import com.exproject.pattern.composite.Observer;
import com.exproject.pattern.composite.PlayData;
import java.util.Iterator;

public class Player implements Observer {

  private Point now_point = new Point(0, 0);
  private Points moveable = new Points(8);

  private Board board;
  private boolean team;
  private final String[] info;

  public Player(String[] info) {
    this.info = info;
  }

  public int setBatch(boolean team, int masag) {
    this.team = team;
    // 마상 선택 기다림
    return 1;
  }

  public String[] getPlayerInfo() {
    return info;
  }

  public void updata(PlayData playdata) {

    System.out.println(playdata.getCount() + "수");
    String move = playdata.getLastCommand();
    System.out.println(move + "이동");
  }
}
