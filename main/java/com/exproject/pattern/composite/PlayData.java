package com.exproject.pattern.composite;

import java.util.Iterator;

public interface PlayData {

	public String getLastCommand();
	
	public int getCount();
	
	public boolean isTurn();
	
	public Iterator<String> getCommandList();
	
	public Iterator<String> getNowPath();

}