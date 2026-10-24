package com.ex01.user;

import com.ex01.board.Board;
import com.ex01.user.Player;
import java.util.Map;
import java.util.HashMap;

public class AbstractPlayer implements Player {

  private static final Map<String, AbstractPlayer> playerdb = new HashMap<>();

  private final String name;
  private final int code;
  private Board board = null;

  public static AbstractPlayer of(String name) {
    return playerdb.put(name, new AbstractPlayer(name));
  }

  private AbstractPlayer(String name) {
    this.name = name;
    code = name.hashCode();
    System.out.println(name+code);
  }

  public String name() {
    return name;
  }

  public void setBoard(Board board) {
    this.board = board;
  }
  
  public void setMove(int move){
    
  }

  @Override
  public int hashCode() {
    return code;
  }

  @Override
  public boolean equals(Object obj) {
    return obj != null && obj instanceof AbstractPlayer && ((AbstractPlayer) obj).name().equals(name);
  }

  @Override
  public String toString() {
    return "[" + name + "] Code: " + code;
  }
}
