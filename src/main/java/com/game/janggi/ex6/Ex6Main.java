package com.game.janggi.ex6;

// 장기
public final class Ex6Main {

	public static void msg(String msg) {
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		msg("장기게임 시작");
		Player p1 = new Player("한나라");
		Player p2 = new Player("초나라");
		BattleRoom room = new BattleRoom(p1,p2);

		int p = 11;
		
		int[] board = new int[99];
		msg("종료");
	}

}
/*
 *  서버
 *  플레이어
 *   1  2   3  4  5   6  7
 *  왕 차 포 마 상 사 쫄
 *  한 =20
 *  초 =10
 */
