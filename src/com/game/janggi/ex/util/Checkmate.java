package com.game.janggi.ex.util;

import com.game.janggi.ex.Board;
import com.game.janggi.ex.interfacemod.Piece;
import com.game.janggi.ex.interfacemod.Piece.PieceName;

public class Checkmate {

	private Board board;
	private Piece king;
	private Points points = new Points(30);
	private Piece tmp_piece;

	private boolean checkCha(Move m) {
		m.move();
		while (m.scope()) {
			tmp_piece = board.getPiece(Move.point);
			if (tmp_piece != null && !king.isTeam(tmp_piece) && tmp_piece.getPieceName() == PieceName.CHA) {
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
