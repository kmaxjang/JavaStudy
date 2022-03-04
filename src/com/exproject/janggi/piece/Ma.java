package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.PieceSet;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.PieceBuild;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class Ma extends Piece {

	private Board board;
	private Points points = new Points(8);
	private Point point = new Point();
	private Point oldpoint = new Point();
	private Name killname = null;
	private PieceSet tmp_piece;

	Move[] way_all = {
	    Move.UP,
	    Move.RIGHTUP,
	    Move.RIGHT,
	    Move.RIGHTDOWN,
	    Move.DOWN,
	    Move.LEFTDOWN,
	    Move.LEFT,
	    Move.LEFTUP
	};

	public Ma(Board board, PieceBuild piece) {
		super(piece.getGroup(), piece.getName());
		point.set(piece.getPosition());
		oldpoint.set(piece.getOldPosition());
		killname = piece.getKillName();
		this.board = board;
	}

	/*
	 * null = 기록 다른편일땄1�7 = 기록 장군을1�7 아닐땄1�7= 기록
	 */
	private void movable() {
		points.clear();

		for (int w = 0; w < way_all.length; w += 2) {
			Move.point.set(getPosition());
			way_all[w].move();
			if (way_all[w].scope() && board.getPiece(Move.point) == null) {
				way_all[w + 1].move();
				if (way_all[w + 1].scope()) {
					moveChack(Move.point);
				}
				way_all[(w + 6) % 8].move(2);
				if (way_all[(w + 6) % 8].scope()) {
					moveChack(Move.point);
				}
			}
		}
	}

	private boolean moveChack(Point p) {
		tmp_piece = board.getPiece(p);
		if (tmp_piece == null) {
			points.add(p);
			return true;
		}
		if (!getGroup().equals(tmp_piece.getGroup())) {
			points.add(p);
		}
		return false;
	}

	@Override
	public Point getPosition() {
		return point;
	}

	@Override
	public Point getOldPosition() {
		return oldpoint;
	}

	@Override
	public Name getKillPiece() {
		return killname;
	}

	@Override
	public Iterator<Point> getMovable() {
		return null;
	}

	@Override
	public boolean move(Point movepoint) {
		return false;
	}
}
