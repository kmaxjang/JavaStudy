package com.exproject.janggi.interfacemod;

import java.util.Iterator;

import com.exproject.janggi.util.Point;

// 장기말 정의 인터페이스
// 1= 한
// 2 = 초
// 1	2	3	4	5	6	7
//왕	졸	사	상	마	포	차

public interface Piece{
    
    public enum Info{
	TEAM(0), CLASS(1), NOW_X(2), NOW_Y(3), OLD_X(4), OLD_Y(5), KILL(6);
	
	public final int point;
	
	private Info( int point ) {
	    this.point = point;
	}
    };
    
    public enum Team{
	HAN("1", 1.5), CHO("2", 0);
	
	public final String number;
	public final double score;
	
	private Team( String number, double score ) {
	    this.number = number;
	    this.score = score;
	}
    }
    
    public enum ClassName{
	KING("1", 0), JOL("2", 2), SA("3", 3), SAG("4", 3), MA("5", 5), POO("6", 7), CHA("7", 13);
	
	public final String number;
	public final double score;
	
	private ClassName( String classnumber, double score ) {
	    this.number = classnumber;
	    this.score = score;
	}
    }
    
    public ClassName getClassName(); // 장기말 이름 왕 차 포 마 상 쫄(병) 사
    
    public ClassName getKillClass();
    
    public Team getTeam(); // 초 한
    
    public boolean equalsTeam(Piece piece);
    
    public int info(); // 문자정보 7자리
    
    public int parseInt( Info p ); // 7자리 개별정수
    
    public String parse( Info p ); // 7자리 개별문자
    
    public boolean move( Point move, ClassName killclass ); // 이동
    
    public Point getPosition(); // 현재위치
    
    public Iterator<Point> movable();
}
