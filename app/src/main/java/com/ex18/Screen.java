package com.ex18;

import com.ex18.Mark;

public class Screen {

  private final String[] turn_mark = {Mark.get("turn_on"), Mark.get("turn_off")};
  private final String[] timer_life = {Mark.get("life_on"), Mark.get("life_off")};
  private final String[] time_number = new String[60];

  {
    for (int i = 0; i < time_number.length; i++) {
      String raw = String.format("%02d", i);
      time_number[i] = Mark.get(raw.charAt(0) - '0') + Mark.get(raw.charAt(1) - '0');
    }
  }

  private final String board_background = Mark.get("board_background");
  private final String[] board_movemark = {
    Mark.get("movable"), Mark.get("immovable"), Mark.get("can_capture"), Mark.get("cannot_capture")
  };

  private final String[] piece = new String[14];

  {
    for (int i = 0; i < piece.length; i++) {
      piece[i] = Mark.get(i + 19);
    }
  }

  private StringBuilder screen = new StringBuilder();

private StringBuilder[] playerbar = new StringBuilder[2];
{
  playerbar[0] = new StringBuilder(String.format("%s%-10s %s%s",turn(true),"player1",life(1),timer(3,0)));
  playerbar[1] = new StringBuilder(String.format("%s%-10s %s%s",turn(true),"player2",life(5),timer(5,30)));
}

  public void setScreen() {

    screen.append(playerbar[0]);
    screen.append("\n");

    StringBuilder board = new StringBuilder(200);
    for (int i = 0; i < 90; i++) {
      board.append(board_background);
      if ((i + 1) % 9 == 0) {
        board.append("\n");
      }
    }
    screen.append(board);
    screen.append(board.length());
    int p = screen.length();
    screen.append(playerbar[1]);
    screen.append("\n");
    
    screen.delete(0,2);
    screen.insert(0,turn(false));
    screen.delete(p,p+2);
    screen.insert(p,turn(true));
    /*
        for(int i=0; i < Mark.size(); i++ ){
        String c = Mark.get(i);
          screen.append(c);
          screen.append(c.length());
          screen.append("\n");
        }
    //*/
  }

  private String life(int life) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 3; i++) {
      sb.append(timer_life[i < life ? 0 : 1]);
    }
    return sb.toString();
  }

  private String turn(boolean turn) {
    return turn_mark[turn ? 0 : 1];
  }

  private String timer(int mm, int ss) {
    return time_number[mm] + ":" + time_number[ss];
    /*
        String raw = String.format("%02d:%02d", mm, ss);
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < raw.length(); i++) {
          char c = raw.charAt(i);
          if (c >= '0' && c <= '9') {
            out.append(number[c - '0']);
          } else {
            out.append(c);
          }
        }
        return out.toString();
    */
  }

  public void print() {
    // turn mark
    // player name
    // timer

    // board

    // turn mark
    // player name
    // timer
    System.out.println(screen);
  }
}
