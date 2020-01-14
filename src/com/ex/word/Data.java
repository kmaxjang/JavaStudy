package com.ex.word;

import java.util.Iterator;

public interface Data {

  public long getPlayer1Time();

  public long getPlayer2Time();

  public Integer getLastTurn();

  public int getCount();

  public boolean isPlayTurn();

  public Iterator<Integer> getRecord();
}
