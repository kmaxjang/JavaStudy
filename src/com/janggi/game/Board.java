package com.janggi.game;

public final class Board<T> {

	private final int max_x = 9;
	private final int max_y = 10;
	private T[][] board;
	private int count;

	public Board() {
		board = (T[][]) new Object[max_x][max_y];
	}

	public int getCount() {
		return count;
	}
	
	public T getPiece(int x, int y) {
		return board[x][y];
	}

	public T getPiece(Point p) {
		return board[p.x][p.y];
	}

	public boolean isPiece(int x, int y) {
		return board[x][y] != null;
	}

	public boolean isPiece(Point p) {
		return board[p.x][p.y] != null;
	}
	
	public boolean inLine(int x, int y) {
		return (-1 < x && max_x > x && -1 < y && max_y > y);
	}

	public boolean inLine(Point p) {
		return (-1 < p.x && max_x > p.x && -1 < p.y && max_y > p.y);
	}
	
	public boolean setPiece() {
		return false;
	}
}
/*
 * 0 공백 1 한 2 초 1 왕 2 차 3 포 4 마 5 상 6 사 7 졸 ex) 12 한차 27 초졸
 */
