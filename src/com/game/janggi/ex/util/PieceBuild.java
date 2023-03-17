package com.game.janggi.ex.util;

import com.game.janggi.ex.interfacemod.PieceSet.Team;
import com.game.janggi.ex.interfacemod.PieceSet.PieceName;

public class PieceBuild {

	private Team group;
	private PieceName name;
	private Point now = new Point();
	private Point old = new Point();
	private PieceName kill = null;

	public void set(String piece) {
		group = Team.get(piece.substring(0, 1));
		name = PieceName.get(piece.substring(1, 2));
		now.set(piece.substring(2, 4));
		old.set(piece.substring(4, 6));
		int k = Integer.parseInt(piece.substring(6));
		if (k == 0) {
			kill = null;
		} else {
			kill = PieceName.get(piece.substring(6));
		}
	}

	public Team getGroup() {
		return group;
	}

	public PieceName getName() {
		return name;
	}

	public Point getPosition() {
		return now;
	}

	public Point getOldPosition() {
		return old;
	}

	public PieceName getKillName() {
		return kill;
	}
}
