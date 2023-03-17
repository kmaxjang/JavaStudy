package com.game.janggi.ex;

import com.game.janggi.ex.interfacemod.Piece;
import com.game.janggi.ex.util.Point;

/* 장기번호
 * 1 = 한 true
 * 2 = 초 false
 * 왕	졸	사	상	마	포	차
 * 1	2	3	4	5	6	7
 * 좌표 x y
 * 
 * ex> 1141 => 한 왕 x=4 y=1
 */

public class GameRule {
    
    enum PieceInfo{
	CHO( "초", 15),
	HAN( "한", 0),
	KING( "왕", 0),
	CHA( "차", 130),
	POO( "포", 70),
	MA( "마", 50),
	SAG( "상", 30),
	SA( "사", 30),
	JOL( "졸", 20);
	
	private final Piece name;
	private final int score;
	
	private PieceInfo( Piece name, int score ) {
	    this.name = name;
	    this.score = score;
	}
	
	public Piece getClassName(){
	    return name;
	}
	
	public int score(){
	    return score;
	}
    }
    
    private Board board;
    // 장기말 기본정보
    private int[] defaultpieceset =
	{ 1700000, 1612120, 1330300, 1141410, 1350500, 1672720, 1780800, 1203030, 1223230, 1243430, 1263630, 1283830,
	2709090, 2617170, 2339390, 2148480, 2359590, 2677770, 2789890, 2206060, 2226260, 2246460, 2266660, 2286860 };
	
    private Point temp_point = new Point(0, 0);
    
    public GameRule() {
	board = new Board();
    }
    
    public void setDefaultPieceSet(){
	setPiecePosition(defaultpieceset);
    }
    
    public void setPieceSet( int[] pieceset ){
	
    }
    
    public void setPiecePosition( int[] pieceset ){
	for( int i = 0; i < pieceset.length; i++ ){
	    setPiece(pieceset[i]);
	}
    }
    
    public void setMaSagPosition( boolean taem, int choice ){
	int[] point =
	    { 10, 20, 60, 70 };
	int[] masag =
	    { 4545, 4554, 5445, 5454 };
	int piece = (taem) ? 1000 : 2000;
	int tmp = 0;
	int c = masag[choice % 4];
	for( int i = 0; i < masag.length; i++ ){
	    tmp = c % 10;
	    c = c / 10;
	    System.out.println("+" + (piece + (tmp * 100) + point[i]));
	    setPiece((piece + (tmp * 100) + point[i] + ((taem) ? 0 : 9)));
	}
    }
    
    public Board getBoard(){
	return board;
    }
    
    public void setPiece( int piece ){
	int y = piece % 10;
	piece /= 10;
	int x = piece % 10;
	piece /= 10;
	temp_point.set(x, y);
	
    }
    
    public int getPiece( Piece piece ){
	return piece.infoCommand();
    }
    
    public boolean isCheckmate(){
	// 차 포
	
	// 마
	// 상
	// 졸
	
	return false;
    }
}