package com.janggi.game;

import com.janggi.game.util.Group;
import com.janggi.game.util.MovePoints;
import com.janggi.game.util.PieceSet;

public abstract class Piece {

	protected final Group group;
	protected final PieceSet piece;

	public Piece(Group group, PieceSet piece) {
		this.group = group;
		this.piece = piece;
	}

	public Group getGroup() {
		return group;
	}

	public PieceSet getPiece() {
		return piece;
	}

	public boolean equals(Group group) {
		return this.group == group;
	}

	public boolean equals(PieceSet piece) {
		return this.piece == piece;
	}

	public boolean equals(Piece piece) {
		return (group == piece.getGroup() && this.piece == piece.getPiece());
	}

	public abstract boolean setMove(Point move);

	public abstract MovePoints getMoveList();
}
