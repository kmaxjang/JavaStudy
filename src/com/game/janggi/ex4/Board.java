package com.jjanggi2;
import java.awt.Point;
import java.util.Iterator;
import java.util.List;

public interface Board {

	public int maxx = 9; // ���α���
	public int maxy =10; // ���α���

	public Chess[][] board = new Chess[maxx][maxy]; // �����

	public boolean isCheck(Point position);
	
	public Chess getChess(Point position);
	
	public void setChess(Chess chess);
	
	public Chess[] getAllChess();
	
	public Iterator<Piece> getNowBoard();
	
	public int getNowCount();
	
}
