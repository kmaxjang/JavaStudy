package com.exproject.pattern.observer;

import java.util.Iterator;
import com.exproject.pattern.observer.Observer;
import com.exproject.pattern.observer.PlayData;

public class Player implements Observer {

	private String name;
	private Server server;
	private boolean turn = true;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setServer(Server s) {
		server = s;
		server.add(this);
	}

	public void play(String[] data) {
		
	}

	public boolean turn() {
		return turn;
	}

	@Override
	public String[] getPlayerInfo() {

		return null;
	}

	@Override
	public void update(PlayData playdata) {
		System.out.print(name + "> ");
/*
		for (String s : playdata.getMoveList())
			System.out.print(s);
*/
		System.out.println("");
		turn = false;

	}
}
