package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.interfacemod.PieceMove;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class Ma implements PieceMove {
	private Board board;
	private Points points = new Points(8);
	private Piece tmp_piece;

	public Ma() {
	}

	/*
	 * null = 기록 다른편일땄1�7 = 기록 장군을1�7 아닐땄1�7= 기록
	 */
	public Iterator<Point> movable(Board b, Piece ma) {
		this.board = b;
		points.clear();
		Move.point.set(ma.getPosition());
		Move.UP.move();
		Move.UP.move();
		if (Move.UP.scope()) {
			Move.DOWN.move();
			if (board.getPiece(Move.point) == null) {
				Move.LEFTUP.move();
				if (Move.LEFTUP.scope()) {
					moveChack(ma, Move.point);
				}
				Move.RIGHT.move();
				Move.RIGHT.move();
				if (Move.RIGHT.scope()) {
					moveChack(ma, Move.point);
				}
			}
		}
		Move.point.set(ma.getPosition());
		Move.DOWN.move();
		Move.DOWN.move();
		if (Move.DOWN.scope()) {
			Move.UP.move();
			if (board.getPiece(Move.point) == null) {
				Move.LEFTDOWN.move();
				if (Move.LEFTDOWN.scope()) {
					moveChack(ma, Move.point);
				}
				Move.RIGHT.move();
				Move.RIGHT.move();
				if (Move.RIGHT.scope()) {
					moveChack(ma, Move.point);
				}
			}
		}
		Move.point.set(ma.getPosition());
		Move.LEFT.move();
		Move.LEFT.move();
		if (Move.LEFT.scope()) {
			Move.RIGHT.move();
			if (board.getPiece(Move.point) == null) {
				Move.LEFTUP.move();
				if (Move.LEFTUP.scope()) {
					moveChack(ma, Move.point);
				}
				Move.DOWN.move();
				Move.DOWN.move();
				if (Move.DOWN.scope()) {
					moveChack(ma, Move.point);
				}
			}
		}
		Move.point.set(ma.getPosition());
		Move.RIGHT.move();
		Move.RIGHT.move();
		if (Move.RIGHT.scope()) {
			Move.LEFT.move();
			if (board.getPiece(Move.point) == null) {
				Move.RIGHTUP.move();
				if (Move.RIGHTUP.scope()) {
					moveChack(ma, Move.point);
				}
				Move.DOWN.move();
				Move.DOWN.move();
				if (Move.DOWN.scope()) {
					moveChack(ma, Move.point);
				}
			}
		}
		return points.getMovable();
	}

	private boolean moveChack(Piece ma, Point p) {
		tmp_piece = board.getPiece(p);
		if (tmp_piece == null) {
			points.add(p);
			return true;
		}
		if (ma.isTeam(tmp_piece)) {
			points.add(p);
		}
		return false;
	}
}
