package com.exproject.janggi;

import java.util.ArrayList;
import java.util.Iterator;

import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.interfacemod.PieceMove;
import com.exproject.janggi.piece.Cha;
import com.exproject.janggi.piece.Jol;
import com.exproject.janggi.piece.King;
import com.exproject.janggi.piece.Ma;
import com.exproject.janggi.piece.PieceSet;
import com.exproject.janggi.piece.Poo;
import com.exproject.janggi.piece.Sa;
import com.exproject.janggi.piece.Sag;
import com.exproject.janggi.util.Point;

public class Board{
    
    private Point tmp = new Point(0, 0);
    // 장기말 목록
    private ArrayList<Piece> piece_list = new ArrayList<Piece>();
    private ArrayList<String> orderlist = new ArrayList<String>();
    // 장기판 크기
    public final int MIN_X = 0;
    public final int MIN_Y = 0;
    public final int MAX_X = 9;
    public final int MAX_Y = 10;
    // 한 궁좌표
    public final Point[] castleup =
	{
	new Point(3, 0),
	new Point(4, 0),
	new Point(5, 0),
	new Point(3, 1),
	new Point(4, 1),
	new Point(5, 1),
	new Point(3, 2),
	new Point(4, 2),
	new Point(5, 2),
	};
    // 초 궁좌표
    public final Point[] castledown =
	{
	new Point(3, 7),
	new Point(4, 7),
	new Point(5, 7),
	new Point(3, 8),
	new Point(4, 8),
	new Point(5, 8),
	new Point(3, 9),
	new Point(4, 9),
	new Point(5, 9),
	};
    private PieceMove pm = null;
    
    private int[] defaultpieceset =
	{
	1700000, 1612120, 1330300, 1141410, 1350500, 1672720, 1780800, 1203030, 1223230, 1243430,
	1263630, 1283830, 2709090, 2617170, 2339390, 2148480, 2359590, 2677770, 2789890, 2206060,
	2226260, 2246460, 2266660, 2286860
	};
	
    public Board() {
	for(int pieceint : defaultpieceset){
	    setPiece(new PieceSet(pieceint));
	}
	
	int[] han =
	    { 1410100, 1520200, 1460600, 1570700 };
	int[] cho =
	    { 2419190, 2529290, 2469690, 2579790 };
	    
	for(int piece : han){
	    setPiece(new PieceSet(piece));
	}
	
	for(int piece : cho){
	    setPiece(new PieceSet(piece));
	}
    }
    
    public Piece getPiece( int x, int y ){
	tmp.set(x, y);
	return index(tmp);
    }
    
    public Piece getPiece( Point p ){
	return index(p);
    }
    
    private void setPiece( Piece piece ){
	if(piece != null){
	    piece_list.add(piece);
	}
    }
    
    public boolean setMove( Piece piece, Point move ){
	Iterator<Point> move_list = movable(piece);
	while(move_list.hasNext()){
	    if(move_list.next().equals(move)){
		Piece kill = index(move);
		if(kill != null){
		    piece_list.remove(kill);
		    piece.move(move, kill.getClassName());
		}else {
		 piece.move(move, null);  
		}		
		orderlist.add(piece.toString());
		return true;
	    }
	}
	return false;
    }
    
    public Iterator<Piece> getPieceList(){
	return piece_list.iterator();
    }
    
    private Piece index( Point point ){
	for(Piece piece : piece_list){
	    if(piece.getPosition().equals(point)){
		return piece;
	    }
	}
	return null;
    }
    
    public Iterator<Point> movable( Piece piece ){
	switch(piece.getClassName()){
	    case CHA :
		pm = new Cha(this);
		System.out.println("차");
		break;
	    case POO :
		pm = new Poo(this);
		System.out.println("포");
		break;
	    case MA :
		pm = new Ma(this);
		System.out.println("마");
		break;
	    case SAG :
		pm = new Sag(this);
		System.out.println("상");
		break;
	    case JOL :
		pm = new Jol(this);
		System.out.println("졸");
		break;
	    case SA :
		pm = new Sa(this);
		System.out.println("사");
		break;
	    case KING :
		pm = new King(this);
		System.out.println("왕");
		break;
	}
	return pm.movable(piece);
    }
}
