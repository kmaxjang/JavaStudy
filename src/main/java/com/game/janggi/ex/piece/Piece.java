package com.game.janggi.ex.piece;

import java.util.Iterator;

import com.game.janggi.ex.interfacemod.PieceSet;
import com.game.janggi.ex.util.Move;
import com.game.janggi.ex.util.Point;

// 장기말 기본정의 Piece인터페이스 구현
public abstract class Piece implements PieceSet {

	public Move[] way = {
	    Move.UP,
	    Move.RIGHTUP,
	    Move.RIGHT,
	    Move.RIGHTDOWN,
	    Move.DOWN,
	    Move.LEFTDOWN,
	    Move.LEFT,
	    Move.LEFTUP
	};
	private final Team group;
	private final PieceName piecename;

	public Piece(Team group, PieceName piecename) {
		this.group = group;
		this.piecename = piecename;
	}

	@Override
	public Team getTeam() {
		return group;
	}

	@Override
	public PieceName getName() {
		return piecename;
	}

	@Override
	public abstract Point getPosition();

	@Override
	public abstract Point getOldPosition();

	@Override
	public abstract PieceName getKillPiece();

	public abstract Iterator<Point> getMovable();

	public abstract boolean move(Point movepoint);

	public boolean equals(Team group) {
		return (this.group == group);
	}

	public boolean equals(PieceName piece) {
		return (this.piecename == piece);
	}

	public boolean equals(Point position) {
		return (getPosition().equals(position));
	}

	public String toString() {
		StringBuffer pieceinfo = new StringBuffer();
		pieceinfo.append(getTeam().number);
		pieceinfo.append(getName().number);
		pieceinfo.append(getPosition().toString());
		pieceinfo.append(getOldPosition().toString());
		pieceinfo.append(getKillPiece() == null ? 0 : getKillPiece().number);
		return pieceinfo.toString();
	}
}
