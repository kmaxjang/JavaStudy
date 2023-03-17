package com.game.janggi.ex4.server;


import java.util.Iterator;

import com.game.janggi.ex4.Events;
import com.game.janggi.ex4.Player;

public class User extends Player{
	
	private MainServer ms= null;
	private String id;
	private String nickname;
	private int setting =0;
	
	
	public User(String id, String nickname) {
		 this.id = id;
		 this.nickname = nickname;	
	}
	
	@Override
	public String getID() {		
		return id;
	}
	
	@Override
	public String getNickname() {		
		return nickname;
	}
	
	@Override
	public void Procedure(Events e) {
		
		
	}
	

	@Override
	public boolean getApply() {
		System.out.println("��� ���� ��û");
		return false;
	}
	
}
