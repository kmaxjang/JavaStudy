package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.PieceSet;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.PieceBuild;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class Cha extends Piece {
	private Board board;
	private Points points = new Points(21);
	private Point point = new Point();
	private Point oldpoint = new Point();
	private Name killname = null;
	private PieceSet tmp_piece;

	public Cha(Board board, PieceBuild piece) {
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
			while (way[w].scope() && moveChack(Move.point)) {
				way[w].move();
			}
		}

		Move.point.set(getPosition());
		if (getPosition().equals(board.castleup[1]) || getPosition().equals(board.castledown[1])) {
			Move.LEFTDOWN.move();
			if (moveChack(Move.point)) {
				Move.LEFTDOWN.move();
				moveChack(Move.point);
			}
		} else if (getPosition().equals(board.castleup[3]) || getPosition().equals(board.castledown[3])) {
			Move.LEFTUP.move();
			if (moveChack(Move.point)) {
				Move.LEFTUP.move();
				moveChack(Move.point);
			}
		} else if (getPosition().equals(board.castleup[5]) || getPosition().equals(board.castledown[5])) {
			Move.RIGHTUP.move();
			if (moveChack(Move.point)) {
				Move.RIGHTUP.move();
				moveChack(Move.point);
			}
		} else if (getPosition().equals(board.castleup[7]) || getPosition().equals(board.castledown[7])) {
			Move.RIGHTDOWN.move();
			if (moveChack(Move.point)) {
				Move.RIGHTDOWN.move();
				moveChack(Move.point);
			}
		} else if (getPosition().equals(board.castleup[8]) || getPosition().equals(board.castledown[8])) {
			Move.RIGHTUP.move();
			moveChack(Move.point);
			Move.DOWN.move(2);
			moveChack(Move.point);
			Move.LEFT.move(2);
			moveChack(Move.point);
			Move.UP.move(2);
			moveChack(Move.point);
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
