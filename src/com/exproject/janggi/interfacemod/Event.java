package com.exproject.janggi.interfacemod;

import java.util.Iterator;

public interface Event<T> {

  public T getLastOrder(); // 마지막 행동

  public int getInning(); // 이닝

  public Iterator<T> getAllOrder(); // 전체 행동
  
  public Iterator<T> nowPath(); // 현재배치

  public boolean Turn(); // 차래
}
