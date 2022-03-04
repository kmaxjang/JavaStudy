package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.PieceSet;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.PieceBuild;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class Sag extends Piece {

	private Board board;
	private Points points = new Points(8);
	private Point point = new Point();
	private Point oldpoint = new Point();
	private Name killname = null;
	private PieceSet tmp_piece;

	public Sag(Board board, PieceBuild piece) {
		super(piece.getGroup(), piece.getName());
		point.set(piece.getPosition());
		oldpoint.set(piece.getOldPosition());
		killname = piece.getKillName();
		this.board = board;
	}

	private void movable() {
		points.clear();
		for (int w = 0; w < way.length; w += 2) {
			Move.point.set(getPosition());
			way[w].move();
			if (way[w].scope() && board.getPiece(Move.point) == null) {

				way[w + 1].move();
				if (way[w + 1].scope() && board.getPiece(Move.point) == null) {
					way[w + 1].move();
					if (way[w + 1].scope()) {
						moveChack(Move.point);
					}
				}
				way[(w + 6) % 8].move(2);
				way[(w + 5) % 8].move();
				if (way[(w + 5) % 8].scope() && board.getPiece(Move.point) == null) {
					way[(w + 7) % 8].move();
					if (way[(w + 7) % 8].scope()) {
						moveChack(Move.point);
					}
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
