package com.game.janggi.ex3.game;

import java.util.List;
import java.util.ArrayList;

public final class History<T> {

  private List<T> list = new ArrayList<>();
  private int lastcount = -1;
  private int nowcount = 0;
  private boolean flag = false;

  public T forward() {
    T data = null;
    if (lastcount > nowcount) {
      data = list.get(nowcount);
      nowcount++;
    } else {
      System.out.print("마지막");
    }
    return data;
  }

  public T rewind() {
    T data = null;
    if (0 <= nowcount) {
      data = list.get(nowcount);
      nowcount--;
    } else {
      System.out.print("처음");
    }
    return data;
  }

  public int getNowCount() {
    return nowcount;
  }

  public int getLastCount() {
    return lastcount;
  }

  public void add(T data) {
    list.add(data);
    lastcount++;
    flag = true;
  }

  public boolean isUpdate() {
    boolean tmp = flag;
    flag = false;
    return tmp;
  }
}
