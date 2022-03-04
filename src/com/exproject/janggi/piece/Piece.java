package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.interfacemod.PieceSet;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.Point;

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
	private final Group group;
	private final Name piecename;

	public Piece(Group group, Name piecename) {
		this.group = group;
		this.piecename = piecename;
	}

	@Override
	public Group getGroup() {
		return group;
	}

	@Override
	public Name getName() {
		return piecename;
	}

	@Override
	public abstract Point getPosition();

	@Override
	public abstract Point getOldPosition();

	@Override
	public abstract Name getKillPiece();

	public abstract Iterator<Point> getMovable();

	public abstract boolean move(Point movepoint);

	public boolean equals(Group group) {
		return (this.group == group);
	}

	public boolean equals(Name piece) {
		return (this.piecename == piece);
	}

	public boolean equals(Point position) {
		return (getPosition().equals(position));
	}

	public String toString() {
		StringBuffer pieceinfo = new StringBuffer();
		pieceinfo.append(getGroup().number);
		pieceinfo.append(getName().number);
		pieceinfo.append(getPosition().toString());
		pieceinfo.append(getOldPosition().toString());
		pieceinfo.append(getKillPiece() == null ? 0 : getKillPiece().number);
		return pieceinfo.toString();
	}
}
