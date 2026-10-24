package com.ex01;

import java.util.HashSet;
import java.util.Set;

/** 시간단위 : 초
 * 시작시간 : 10~ 6000초, 기본 300초
 * 초읽기: 초 10~ <= 시작시간, 기본 30초
 * 마지막 기회 : 0~10회 기본 3회
 */
 
public final class Timer {
  private int starttime = 300;
  private int lasttime = 30;
  private int lastcount = 3;
  
  private Set<Turn> plaryer = new HashSet<>();

  public Timer() {}

  public Timer(int start, int last, int count) {
    setTimer(start, last, count);
  }

  public void setTimer() {
    starttime = 300;
    lasttime = 30;
    lastcount = 3;
  }

  public void setTimer(int start, int last, int count) {
    starttime = Math.min(Math.max(10, start), 6000);
    lasttime = Math.min(Math.max(10, last), starttime);
    lastcount = Math.min(Math.max(0, count), 10);
  }
  
  private void tick(){
    
  }
}

interface Turn{
void update();

}
