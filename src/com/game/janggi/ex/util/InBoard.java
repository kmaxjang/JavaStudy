package com.game.janggi.ex.util;

import com.game.janggi.ex.Board;
import com.game.janggi.ex.interfacemod.PieceSet.Team;
import com.game.janggi.ex.interfacemod.Piece;


public class InBoard {

	private Board board;
	private Team group;
	private boolean turn = false;

	public InBoard(Board board, Team group) {
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
