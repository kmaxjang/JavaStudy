package com.game.worm;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {

  private List<Schedule> schedule = new ArrayList<Schedule>();

  public boolean add(Schedule work) {
    return schedule.add(work);
  }

  public void run() {
  int out = 0;
    while (true) {
      for (Schedule s : schedule) {
        if (s.isWork()) {
          s.runWork();
        }
      }
      if(out > 1000){
        break;
      }else{
        out++;
      }
    }
  }
}
