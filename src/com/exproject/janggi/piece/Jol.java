package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.PieceSet;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.PieceBuild;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class Jol extends Piece {

	private Board board;
	private Points points = new Points(5);
	private Point point = new Point();
	private Point oldpoint = new Point();
	private Name killname = null;
	private PieceSet tmp_piece;
	private boolean castle;

	public Jol(Board board, PieceBuild piece) {
		super(piece.getGroup(), piece.getName());
		point.set(piece.getPosition());
		oldpoint.set(piece.getOldPosition());
		killname = piece.getKillName();
		this.board = board;
		castle = (getGroup() == PieceSet.Group.HAN);
	}

	private void movable() {
		points.clear();

		Move.point.set(getPosition());
		Move.RIGHT.move();
		if (Move.RIGHT.scope()) {
			moveChack(Move.point);
		}
		Move.LEFT.move(2);
		if (Move.LEFT.scope()) {
			moveChack(Move.point);
		}

		Move.point.set(getPosition());
		if (castle) {
			Move.DOWN.move();
			if (Move.DOWN.scope()) {
				moveChack(Move.point);
			}
			Move.point.set(getPosition());
			if (Move.point.equals(board.castledown[6])) {
				Move.RIGHTDOWN.move();
				moveChack(Move.point);
			} else if (Move.point.equals(board.castledown[1])) {
				Move.LEFTDOWN.move();
				moveChack(Move.point);
			} else if (Move.point.equals(board.castledown[8])) {
				Move.RIGHTDOWN.move();
				moveChack(Move.point);
				Move.LEFT.move(2);
				moveChack(Move.point);
			}
		} else {
			Move.UP.move();
			if (Move.UP.scope()) {
				moveChack(Move.point);
			}
			Move.point.set(getPosition());
			if (Move.point.equals(board.castleup[3])) {
				Move.LEFTUP.move();
				moveChack(Move.point);
			} else if (Move.point.equals(board.castleup[5])) {
				Move.RIGHTUP.move();
				moveChack(Move.point);
			} else if (Move.point.equals(board.castleup[8])) {
				Move.RIGHTUP.move();
				moveChack(Move.point);
				Move.LEFT.move(2);
				moveChack(Move.point);
			}
		}
	}

	private boolean moveChack(Point p) {
		tmp_piece = board.getPiece(p);
		if (tmp_piece == null) {
			points.add(p);
			return true;
		}
		if (getGroup().equals(tmp_piece.getGroup())) {
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
