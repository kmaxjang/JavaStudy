package com.game.janggi.ex.piece;

import java.util.Iterator;

import com.game.janggi.ex.ex1.Board;
import com.game.janggi.ex.interfacemod.Piece;
import com.game.janggi.ex.interfacemod.PieceMove;
import com.game.janggi.ex.util.Move;
import com.game.janggi.ex.util.Point;
import com.game.janggi.ex.util.Points;

public class Cha implements PieceMove {

	private Board board;
	private Points points = new Points(21);
	private Piece tmp_piece;

	public Cha() {
	}

	/*
	 * null = 기록 다른편일땄1�71ￄ1�77 = 기록 장군을1�71ￄ1�77 아닐땄1�71ￄ1�77= 기록
	 */
	public Iterator<Point> moveable(Board b, Piece cha) {
		this.board = b;
		points.clear();
		Move.point.set(cha.getPosition());
		Move.UP.move();
		while (Move.point.getY() >= board.MIN_Y && moveChack(cha, Move.point)) {
			Move.UP.move();
		}
		Move.point.set(cha.getPosition());
		Move.DOWN.move();
		while (Move.point.getY() < board.MAX_Y && moveChack(cha, Move.point)) {
			Move.DOWN.move();
		}
		Move.point.set(cha.getPosition());
		Move.LEFT.move();
		while (Move.point.getX() >= board.MIN_X && moveChack(cha, Move.point)) {
			Move.LEFT.move();
		}
		Move.point.set(cha.getPosition());
		Move.RIGHT.move();
		while (Move.point.getX() < board.MAX_X && moveChack(cha, Move.point)) {
			Move.RIGHT.move();
		}

		if (cha.getPosition().equals(board.castleup[0]) || cha.getPosition().equals(board.castledown[0])) {
			Move.point.set(cha.getPosition());
			Move.RIGHT.move();
			if (moveChack(cha, Move.point)) {
				Move.RIGHT.move();
				moveChack(cha, Move.point);
			}
		} else if (cha.getPosition().equals(board.castleup[2]) || cha.getPosition().equals(board.castledown[2])) {
			Move.point.set(cha.getPosition());
			Move.LEFT.move();
			if (moveChack(cha, Move.point)) {
				Move.LEFT.move();
				moveChack(cha, Move.point);
			}
		} else if (cha.getPosition().equals(board.castleup[4]) || cha.getPosition().equals(board.castledown[4])) {
			Move.point.set(cha.getPosition());
			Move.LEFTUP.move();
			moveChack(cha, Move.point);
			Move.point.set(cha.getPosition());
			Move.RIGHTUP.move();
			moveChack(cha, Move.point);
			Move.point.set(cha.getPosition());
			Move.LEFTDOWN.move();
			moveChack(cha, Move.point);
			Move.point.set(cha.getPosition());
			Move.RIGHTDOWN.move();
			moveChack(cha, Move.point);
		} else if (cha.getPosition().equals(board.castleup[6]) || cha.getPosition().equals(board.castledown[6])) {
			Move.point.set(cha.getPosition());
			Move.RIGHTUP.move();
			if (moveChack(cha, Move.point)) {
				Move.RIGHTUP.move();
				moveChack(cha, Move.point);
			}
		} else if (cha.getPosition().equals(board.castleup[8]) || cha.getPosition().equals(board.castledown[8])) {
			Move.point.set(cha.getPosition());
			Move.LEFTUP.move();
			if (moveChack(cha, Move.point)) {
				Move.LEFTUP.move();
				moveChack(cha, Move.point);
			}
		}
		return points.getMovable();
	}

	// �3�3�9�4�3�1�2�2 �3�3�9�4�7�5�8�6�4�7�5�9
	private boolean moveChack(Piece cha, Point p) {
		tmp_piece = board.getPiece(p);
		if (tmp_piece == null) {
			points.add(p);
			return true;
		}
		if (cha.isTeam(tmp_piece)) {
			points.add(p);
		}
		return false;
	}
}
