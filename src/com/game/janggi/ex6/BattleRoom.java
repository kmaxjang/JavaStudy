package com.game.janggi.ex6;

public class BattleRoom {

	private Player[] player = new Player[2];
	private Thread thread;
	
	public BattleRoom(Player p1, Player p2) {
		player[0] = p1;
		player[1] = p2;
		thread = new Thread(new Runnable() {
			public void run() {
				System.out.println("게임을 시작합니다.");
				p1.getStartPath();
				p2.getStartPath();
				
				System.out.println("게임을 종료합니다.");
			}
		});
		thread.start();
	}
	
}
