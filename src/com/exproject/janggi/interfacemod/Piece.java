package com.exproject.janggi.interfacemod;

import com.exproject.janggi.util.Point;

// 장기말 정의 인터페이스

public interface Piece {
    
    public enum Info{
	TEAM( 0),
	CLASS( 1),
	NOW_X( 2),
	NOW_Y( 3),
	OLD_X( 4),
	OLD_Y( 5),
	KILL_CLASS( 6);
	
	public final int POINT;
	
	private Info( int point ) {
	    this.POINT = point;
	}
    };
    
    public enum Team{
	CHO("2"),
	HAN("1");
	
	public final String NUMBER;
	
	private Team(String number) {
	    NUMBER = number;	    
	}
    }
    
    public enum ClassName{
	KING( "1"),
	JOL( "2"),
	SA( "3"),
	SAG( "4"),
	MA( "5"),
	POO( "6"),
	CHA( "7");
	
	public final String NUMBER;
	
	private ClassName( String classnumber ) {
	    this.NUMBER = classnumber;
	}
    }
    
    public ClassName getClassName(); // 장기말 이름 왕 차 포 마 상 쫄(병) 사
    
    public Team getTeamName(); // 초 한
    
    public boolean isTeam(Piece piece); // 장기 편 true= 한 false= 초
    
    public String info(); // 문자정보 7자리
    
    public int infoCommand(); // 7자리 정보
    
    public int parseInt( Info p ); // 7자리 개별정수
    
    public String parse( Info p ); // 7자리 개별문자
    
    public boolean move( Point move, Piece killclass ); // 이동
    
    public Point getPosition(); // 현재위치   
}
