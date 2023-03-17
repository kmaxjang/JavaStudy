package com.game.janggi.ex6;

public class Player {

	private String name;
	private Thread thread;
	
	public Player(String name) {
		this.name = name;
		thread = new Thread(new Runnable() {
			public void run() {
				System.out.println(name+"님 반갑습니다.");
				
				System.out.println(name+"님 안녕히가세요");
			}
		});
		thread.start();
	}
	
	public String getName() {
		return name;
	}
	
	public int getStartPath() {
		return 4;
	}
}
