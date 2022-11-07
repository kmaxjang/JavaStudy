package com.jjanggi2.server;


import java.util.Iterator;

import com.jjanggi2.Events;
import com.jjanggi2.Player;

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
