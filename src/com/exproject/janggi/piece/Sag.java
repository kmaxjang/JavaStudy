package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.interfacemod.PieceMove;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class Sag implements PieceMove {

	private Board board;
	private Points points = new Points(8);
	private Piece tmp_piece;

	public Sag() {

	}

	/*
	 * null = 기록 다른편일땄1�7 = 기록 장군을1�7 아닐땄1�7= 기록
	 */
	public Iterator<Point> movable(Board b, Piece sag) {
		this.board = b;
		points.clear();
		Move.point.set(sag.getPosition());
		Move.UP.move();
		Move.UP.move();
		Move.UP.move();
		if (Move.point.getY() >= board.MIN_Y) {
			Move.DOWN.move();
			Move.DOWN.move();
			if (board.getPiece(Move.point) == null) {
				Move.LEFTUP.move();
				if (Move.point.getX() > board.MIN_X && board.getPiece(Move.point) == null) {
					Move.LEFTUP.move();
					moveChack(sag, Move.point);
					Move.RIGHTDOWN.move();
				}
				Move.RIGHT.move();
				Move.RIGHT.move();
				if (Move.point.getX() < board.MAX_X - 1 && board.getPiece(Move.point) == null) {
					Move.RIGHTUP.move();
					moveChack(sag, Move.point);
				}
			}
		}
		Move.point.set(sag.getPosition());
		Move.DOWN.move();
		Move.DOWN.move();
		Move.DOWN.move();
		if (Move.point.getY() < board.MAX_Y) {
			Move.UP.move();
			Move.UP.move();
			if (board.getPiece(Move.point) == null) {
				Move.LEFTDOWN.move();
				if (Move.point.getX() > board.MIN_X && board.getPiece(Move.point) == null) {
					Move.LEFTDOWN.move();
					moveChack(sag, Move.point);
					Move.RIGHTUP.move();
				}
				Move.RIGHT.move();
				Move.RIGHT.move();
				if (Move.point.getX() < board.MAX_X - 1 && board.getPiece(Move.point) == null) {
					Move.RIGHTDOWN.move();
					moveChack(sag, Move.point);
				}
			}
		}
		Move.point.set(sag.getPosition());
		Move.LEFT.move();
		Move.LEFT.move();
		Move.LEFT.move();
		if (Move.point.getX() >= board.MIN_X) {
			Move.RIGHT.move();
			Move.RIGHT.move();
			if (board.getPiece(Move.point) == null) {
				Move.LEFTUP.move();
				if (Move.point.getY() > board.MIN_Y && board.getPiece(Move.point) == null) {
					Move.LEFTUP.move();
					moveChack(sag, Move.point);
					Move.RIGHTDOWN.move();
				}
				Move.DOWN.move();
				Move.DOWN.move();
				if (Move.point.getY() < board.MAX_Y - 1 && board.getPiece(Move.point) == null) {
					Move.LEFTDOWN.move();
					moveChack(sag, Move.point);
				}
			}
		}
		Move.point.set(sag.getPosition());
		Move.RIGHT.move();
		Move.RIGHT.move();
		Move.RIGHT.move();
		if (Move.point.getX() < board.MAX_X) {
			Move.LEFT.move();
			Move.LEFT.move();
			if (board.getPiece(Move.point) == null) {
				Move.RIGHTUP.move();
				if (Move.point.getY() > board.MIN_Y && board.getPiece(Move.point) == null) {
					Move.RIGHTUP.move();
					moveChack(sag, Move.point);
					Move.LEFTDOWN.move();
				}
				Move.DOWN.move();
				Move.DOWN.move();
				if (Move.point.getY() < board.MAX_Y - 1 && board.getPiece(Move.point) == null) {
					Move.RIGHTDOWN.move();
					moveChack(sag, Move.point);
				}
			}
		}
		return points.getMovable();
	}

	private boolean moveChack(Piece sag, Point p) {
		tmp_piece = board.getPiece(p);
		if (tmp_piece == null) {
			points.add(p);
			return true;
		}
		if (sag.isTeam(tmp_piece)) {
			points.add(p);
		}
		return false;
	}
}
