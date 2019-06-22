package com.exproject.pattern.observer;

import com.exproject.pattern.observer.Observer;
import com.exproject.pattern.observer.PlayData;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Server {

  private List<Observer> playerlist = new ArrayList<Observer>();

  public void add(Observer ob) {
    System.out.println("등록");
    playerlist.add(ob);
  }

  public void remove(Observer ob) {
    playerlist.remove(ob);
  }

  private void update() {
	  PlayData playdata = new PlayData() {

		@Override
		public String getLastMove() {
			return null;
		}

		@Override
		public int getCount() {
			return 0;
		}

		@Override
		public boolean isTurn() {
			return false;
		}

		@Override
		public Iterator<String> getMoveList() {
			return null;
		}

		@Override
		public Iterator<String> getNowPath() {
			return null;
		}

		@Override
		public String isGameOver() {
			
			return null;
		}		  
	  };
	  
     for (Observer ob : playerlist) {      
        ob.update(playdata);      
    }  
  }
}
