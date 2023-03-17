package com.game.janggi.ex4.player;

import com.game.janggi.ex4.Events;
import com.game.janggi.ex4.Player;

public class Computer extends Player{

	@Override
	public void Procedure(Events e) {
		
		
	}

	@Override
	public String getNickname() {
		
		return "Computer";
	}

	@Override
	public boolean getApply() {
		return true;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

}
