package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.PieceSet;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.PieceBuild;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class King extends Piece {

	private Board board;
	private Points points = new Points(8);
	private Point point = new Point();
	private Point oldpoint = new Point();
	private Name killname = null;
	private Point[] castle;
	private PieceSet tmp_piece;

	private boolean center = true;

	public King(Board board, PieceBuild piece) {
		super(piece.getGroup(), piece.getName());
		point.set(piece.getPosition());
		oldpoint.set(piece.getOldPosition());
		killname = piece.getKillName();
		this.board = board;

		castle = (getGroup() == Group.HAN) ? board.castleup : board.castledown;
	}

	private void movable() {
		points.clear();
		for (int c = 0; c < castle.length - 1; c++) {
			if (equals(castle[c])) {
				Move.point.set(castle[(c + 1) % 8]);
				moveChack(Move.point);
				way[(c + 5) % 8].move();
				moveChack(Move.point);
				way[(c + 7) % 8].move();
				moveChack(Move.point);
				center = false;
				break;
			}
		}
		if (center && equals(castle[8])) {
			for (int c = 0; c < castle.length - 1; c++) {
				Move.point.set(castle[c]);
				moveChack(Move.point);
			}
		}
		center = true;
	}

	private boolean moveChack(Point p) {
		tmp_piece = board.getPiece(p);
		if (tmp_piece == null) {
			points.add(p);
			return true;
		}
		if (!tmp_piece.equals(getGroup())) {
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
