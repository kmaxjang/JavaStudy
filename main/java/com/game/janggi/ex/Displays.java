package com.game.janggi.ex;

import java.util.Iterator;

import com.game.janggi.ex.interfacemod.PieceSet;
import com.game.janggi.ex.util.Point;

public class Displays {

	private StringBuffer mark = new StringBuffer();
	private final int maxx = 9;
	private final int maxy = 10;

	private PieceSet[][] board = new PieceSet[maxx][maxy];
	private boolean[][] mark_check = new boolean[maxx][maxy];

	private String mark_space = "⬛";
	private String mark_choice = "⭕";

	public Displays() {

	}

	private void reSetBoard() {
		for (PieceSet[] x : board) {
			for (PieceSet y : x) {
				y = null;
			}
		}
	}

	private void reSetMovable() {
		for (boolean[] x : mark_check) {
			for (boolean y : x) {
				y = false;
			}
		}
	}

	public void moveable(Iterator<Point> moves) {
		reSetMovable();
		if (moves != null) {
			while (moves.hasNext()) {
				Point mp = moves.next();
				mark_check[mp.x][mp.y] = true;
				System.out.println("x" + mp.x + " y" + mp.y);
			}
		}
		screen();
	}

	public void displaysUpdata(Iterator<PieceSet> list) {
		reSetBoard();

		while (list.hasNext()) {
			PieceSet piece = list.next();
			Point point = piece.getPosition();
			board[point.x][point.y] = piece;
		}
		screen();
	}

	private void screen() {
		mark.delete(0, mark.capacity());
		mark.append(" 1 2 3 4 5 6 7 8 9\n");
		for (int y = 0; y < maxy; y++) {
			mark.append((y + 1) % 10);
			for (int x = 0; x < maxx; x++) {
				if (mark_check[x][y]) {
					mark.append(mark_choice);
				} else {
					mark.append(getPiece(board[x][y]));
				}
			}
			mark.append('\n');
		}
		System.out.println(mark);
	}

	private String getPiece(PieceSet piece) {
		if (piece != null) {
			switch (piece.group()) {
			case HAN:
				switch (piece.type()) {
				case KING:
					return "🦁";
				case CHA:
					return "🐅";
				case POO:
					return "🦌";
				case MA:
					return "🐴";
				case SAG:
					return "🐘";
				case SA:
					return "🐀";
				case JOL:
					return "🐵";
				}
			case CHO:
				switch (piece.type()) {
				case KING:
					return "🤴";
				case CHA:
					return "👮‍♂️";
				case POO:
					return "👨‍🚒";
				case MA:
					return "👨‍🍳";
				case SAG:
					return "👨‍🔧";
				case SA:
					return "👨‍🏫";
				case JOL:
					return "👨‍🌾";
				}
			}
		}
		return mark_space;
	}

	public static void main(String[] args) {
		PieceSet piece;
		Point tmp_point = Point.in(0,0);
		Displays ds = new Displays();
		com.game.janggi.ex.Board exboard = new com.game.janggi.ex.Board();

		ds.displaysUpdata(exboard.getPieceList());
		piece = exboard.getPiece(0, 3);
		if (piece != null) {
			ds.moveable(piece.getMovable());
		} else {
			ds.moveable(null);
		}
		tmp_point= Point.in(1, 3);
		if (exboard.setMove(piece, tmp_point)) {
			System.out.println("말이동");
		}
		ds.displaysUpdata(exboard.getPieceList());

//	ds.setPieceMove(0, 6, 1, 6);
//	ds.move(new Point(1, 7));
		ds.screen();
	}
}
