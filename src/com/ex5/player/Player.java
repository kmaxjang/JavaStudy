package com.ex5.player;

import com.ex5.server.Client;
import com.ex5.server.Event;

public class Player implements Client {

	private Thread thread = null;
	private boolean flag = true;
	
	private String name;

	public Player(String name) {
		this.name = name;
		thread = new Thread(new Runnable() {
			public void run() {
				System.out.println("플레이어"+name);
				while(flag) {
					join();
				}
				System.out.println("플레이어"+name+"로그아웃 되었습니다.");
			}
		});  
		thread.start();
	}
	
	private void join() {
		
	}
	
	public boolean logout() {
		flag = false;
		return flag;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public boolean end() {		
		return false;
	}

	@Override
	public void updata(Event event) {		 
		
	}
}
