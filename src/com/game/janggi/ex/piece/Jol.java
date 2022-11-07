package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.interfacemod.Piece.Team;
import com.exproject.janggi.interfacemod.PieceMove;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class Jol implements PieceMove {

	private Board board;
	private Points points = new Points(5);
	private Piece tmp_piece;
	private Point[] castle;

	public Jol() {
	}

	/*
	 * null = 기록 다른편일땄1�7 = 기록 장군을1�7 아닐땄1�7= 기록
	 */
	public Iterator<Point> movable(Board b, Piece jol) {
		this.board = b;
		castle = (jol.getTeamName() == Team.HAN) ? board.castleup : board.castledown;
		points.clear();
		Move.point.set(jol.getPosition());
		Move.LEFT.move();
		if (Move.point.getX() >= board.MIN_X)
			moveChack(jol, Move.point);
		Move.point.set(jol.getPosition());
		Move.RIGHT.move();
		if (Move.point.getX() < board.MAX_X)
			moveChack(jol, Move.point);

		if (jol.getTeamName() == Team.HAN) {
			Move.point.set(jol.getPosition());
			Move.DOWN.move();
			if (Move.point.getY() < board.MAX_Y)
				moveChack(jol, Move.point);

			if (jol.getPosition().equals(castle[0])) {
				Move.point.set(jol.getPosition());
				Move.RIGHTDOWN.move();
				moveChack(jol, Move.point);
			} else if (jol.getPosition().equals(castle[2])) {
				Move.point.set(jol.getPosition());
				Move.LEFTDOWN.move();
				moveChack(jol, Move.point);
			} else if (jol.getPosition().equals(castle[4])) {
				Move.point.set(jol.getPosition());
				Move.LEFTDOWN.move();
				moveChack(jol, Move.point);
				Move.point.set(jol.getPosition());
				Move.RIGHTDOWN.move();
				moveChack(jol, Move.point);
			}
		} else {
			Move.point.set(jol.getPosition());
			Move.UP.move();
			if (Move.point.getY() >= board.MIN_Y)
				moveChack(jol, Move.point);

			if (jol.getPosition().equals(castle[6])) {
				Move.point.set(jol.getPosition());
				Move.RIGHTUP.move();
				moveChack(jol, Move.point);
			} else if (jol.getPosition().equals(castle[8])) {
				Move.point.set(jol.getPosition());
				Move.LEFTUP.move();
				moveChack(jol, Move.point);
			} else if (jol.getPosition().equals(castle[4])) {
				Move.point.set(jol.getPosition());
				Move.LEFTUP.move();
				moveChack(jol, Move.point);
				Move.point.set(jol.getPosition());
				Move.RIGHTUP.move();
				moveChack(jol, Move.point);
			}
		}
		return points.getMovable();
	}

	public boolean move(Point p) {

		return false;
	}

	private boolean moveChack(Piece jol, Point p) {
		tmp_piece = board.getPiece(p);
		if (tmp_piece == null) {
			points.add(p);
			return true;
		}
		if (jol.isTeam(tmp_piece)) {
			points.add(p);
		}
		return false;
	}
}
