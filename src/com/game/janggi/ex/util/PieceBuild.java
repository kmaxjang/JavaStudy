package com.exproject.janggi.util;

import com.exproject.janggi.interfacemod.PieceSet.Group;
import com.exproject.janggi.interfacemod.PieceSet.Name;

public class PieceBuild {

	private Group group;
	private Name name;
	private Point now = new Point();
	private Point old = new Point();
	private Name kill = null;

	public void set(String piece) {
		group = Group.get(piece.substring(0, 1));
		name = Name.get(piece.substring(1, 2));
		now.set(piece.substring(2, 4));
		old.set(piece.substring(4, 6));
		int k = Integer.parseInt(piece.substring(6));
		if (k == 0) {
			kill = null;
		} else {
			kill = Name.get(piece.substring(6));
		}
	}

	public Group getGroup() {
		return group;
	}

	public Name getName() {
		return name;
	}

	public Point getPosition() {
		return now;
	}

	public Point getOldPosition() {
		return old;
	}

	public Name getKillName() {
		return kill;
	}
}
