package com.exproject.janggi.util;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.PieceSet.Group;
import com.exproject.janggi.piece.Piece;

public class InBoard {

	private Board board;
	private Group group;
	private boolean turn = false;

	public InBoard(Board board, Group group) {
		this.board = board;
		this.group = group;
	}

	public boolean isTurn() {
		return turn;
	}

	public Piece getPiece(Point point) {
		return board.getPiece(point);
	}

	public boolean setMove() {

		return true;
	}

}
