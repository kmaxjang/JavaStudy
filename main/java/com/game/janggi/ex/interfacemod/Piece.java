package com.game.janggi.ex.interfacemod;

import com.game.janggi.ex.util.Point;

// 장기말 정의 인터페이스

public interface Piece {

    public enum PieceCode {
	TEAM(0), //
	PIECE_NAME(1), //
	POINT(2); //
	
	public final int CODE;
	
	private PieceCode(int code) {
	    this.CODE = code;
	}	
    };

    public enum Team {
	CHO(10), //
	HAN(20);

	public final int CODE;

	private Team(int code) {
	    CODE = code;
	}
		
	public static Team get(int code) {	    
	    switch(code) {
	    case 1: return CHO;
	    case 2: return HAN;
	    }
	    return null;
	}
    }

    public enum PieceName {
	KING(1), //
	JOL(2), //
	SA(3), //
	SAG(4), //
	MA(5), //
	POO(6), //
	CHA(7);

	public final int CODE;

	private PieceName(int code) {
	    CODE = code;
	}
	
	public static PieceName get(int code) {	    
	    switch(code) {
	    case 1: return KING;
	    case 2: return JOL;
	    case 3: return SA;
	    case 4: return SAG;
	    case 5: return MA;
	    case 6: return POO;
	    case 7: return CHA;
	    }
	    return null;
	}
    }

    public PieceName getName(); // 장기말 이름 왕 차 포 마 상 쫄(병) 사

    public Team getTeam(); // 초 한
    
    public Point getPosition(); // 현재위치
    
    public boolean isTeam(); // 장기 편 true= 한 false= 초

    public int info(); // 문자정보 7자리

    public int parseInt(PieceCode p); // 7자리 개별정수

    public boolean move(Point move, Piece killclass); // 이동

    
}
