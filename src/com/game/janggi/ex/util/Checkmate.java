package com.exproject.janggi.util;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.interfacemod.Piece.ClassName;

public class Checkmate {

	private Board board;
	private Piece king;
	private Points points = new Points(30);
	private Piece tmp_piece;

	private boolean checkCha(Move m) {
		m.move();
		while (m.scope()) {
			tmp_piece = board.getPiece(Move.point);
			if (tmp_piece != null && !king.isTeam(tmp_piece) && tmp_piece.getClassName() == ClassName.CHA) {
				return true;
			}
		}
		return false;
	}

	public boolean check(Board b) {
		this.board = b;
		Move.point.set(king.getPosition());
		// 차 경로
		if (checkCha(Move.UP) || checkCha(Move.DOWN) || checkCha(Move.LEFT) || checkCha(Move.RIGHT)) {

		}
		return false;
	}

}