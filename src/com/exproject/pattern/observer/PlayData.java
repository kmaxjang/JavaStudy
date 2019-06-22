package com.exproject.pattern.observer;

import java.util.Iterator;

public interface PlayData {

	public String getLastMove();
	
	public int getCount();
	
	public boolean isTurn();
	
	public Iterator<String> getMoveList();
	
	public Iterator<String> getNowPath();
	
	public String isGameOver();
	
}
