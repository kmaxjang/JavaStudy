package com.game.janggi.ex4;

import java.util.Iterator;

import com.game.janggi.ex4.server.MainServer;

public abstract class Player {
	
	public abstract String getID();
		
	public abstract String getNickname();
	
	public abstract void Procedure(Events e);

	public abstract boolean getApply();
		
}
