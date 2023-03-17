package com.game.janggi.ex.interfacemod;

import java.util.Iterator;

import com.game.janggi.ex.util.Point;

// 장기말 정의 인터페이스
// 1 = 한
// 2 = 초
// 1 2 3 4 5 6 7
// 왕졸사상마포차

public interface PieceSet {

    public enum Team {
	HAN(10), CHO(20);

	public final int number;

	private Team(int number) {
	    this.number = number;
	}

	public static Team get(int name) {
	    switch (name) {
	    case 1:
		return HAN;
	    case 2:
		return CHO;
	    }
	    return null;
	}
    }

    public enum PieceName {
	KING(1), JOL(2), SA(3), SAG(4), MA(5), POO(6), CHA(7);

	public final int number;

	private PieceName(int number) {
	    this.number = number;
	}

	public static PieceName get(int name) {
	    switch (name) {
	    case 1:
		return KING;
	    case 2:
		return JOL;
	    case 3:
		return SA;
	    case 4:
		return SAG;
	    case 5:
		return MA;
	    case 6:
		return POO;
	    case 7:
		return CHA;
	    }
	    return null;
	}
    }

    public Team getTeam(); // 초 한

    public PieceName getName(); // 왕 차 포 마 상 쫄(병) 사

    public Point getPosition(); // 현재위치

    public Point getOldPosition(); // 전위치

    public PieceName getKillPiece(); // 잡은말

    public Iterator<Point> getMovable();
}