package com.game2.worm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Scheduler {

  private List<Schedule> schedule = new ArrayList<Schedule>();
  
  public boolean add(Schedule work) {
    return schedule.add(work);
  }

  public void run() {	  
    while (true) {
      for (Iterator<Schedule> iter = schedule.iterator()  ; iter.hasNext(); ) {
    	  Schedule s = iter.next();
        if (s.isWork()) {
          s.runWork();
        }else {
        	iter.remove();
        	if(schedule.size() == 0) {
        		System.out.println("게임종료");
        		return;
        	}
        }
      }
      try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    }
  }
}
