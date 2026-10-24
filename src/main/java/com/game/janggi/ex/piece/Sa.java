package com.game.janggi.ex.piece;

import java.util.Iterator;

import com.game.janggi.ex.Board;
import com.game.janggi.ex.interfacemod.Piece;
import com.game.janggi.ex.interfacemod.PieceMove;
import com.game.janggi.ex.interfacemod.Piece.Team;
import com.game.janggi.ex.util.Move;
import com.game.janggi.ex.util.Point;
import com.game.janggi.ex.util.Points;

public class Sa implements PieceMove {

	private Board board;
	private Points points = new Points(8);
	private Point[] castle;
	private Piece tmp_piece;

	public Sa() {

	}

	/*
	 * null = 기록 다른편일땄1�7 = 기록 장군을1�7 아닐땄1�7= 기록
	 */
	public Iterator<Point> moveable(Board b, Piece sa) {
		this.board = b;
		castle = (sa.getTeamName() == Team.HAN) ? board.castleup : board.castledown;
		points.clear();
		if (sa.getPosition().equals(castle[0])) {
			Move.point.set(sa.getPosition());
			Move.RIGHT.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.DOWN.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.RIGHTDOWN.move();
			moveChack(sa, Move.point);
		} else if (sa.getPosition().equals(castle[1])) {
			Move.point.set(sa.getPosition());
			Move.LEFT.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.RIGHT.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.DOWN.move();
			moveChack(sa, Move.point);
		} else if (sa.getPosition().equals(castle[2])) {
			Move.point.set(sa.getPosition());
			Move.LEFT.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.LEFTDOWN.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.DOWN.move();
			moveChack(sa, Move.point);
		} else if (sa.getPosition().equals(castle[3])) {
			Move.point.set(sa.getPosition());
			Move.UP.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.RIGHT.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.DOWN.move();
			moveChack(sa, Move.point);
		} else if (sa.getPosition().equals(castle[4])) {
			Move.point.set(sa.getPosition());
			Move.LEFTUP.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.UP.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.RIGHTUP.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.LEFT.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.RIGHT.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.LEFTDOWN.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.DOWN.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.RIGHTDOWN.move();
			moveChack(sa, Move.point);
		} else if (sa.getPosition().equals(castle[5])) {
			Move.point.set(sa.getPosition());
			Move.UP.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.LEFT.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.DOWN.move();
			moveChack(sa, Move.point);
		} else if (sa.getPosition().equals(castle[6])) {
			Move.point.set(sa.getPosition());
			Move.UP.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.RIGHTUP.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.RIGHT.move();
			moveChack(sa, Move.point);
		} else if (sa.getPosition().equals(castle[7])) {
			Move.point.set(sa.getPosition());
			Move.UP.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.LEFT.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.RIGHT.move();
			moveChack(sa, Move.point);
		} else if (sa.getPosition().equals(castle[8])) {
			Move.point.set(sa.getPosition());
			Move.LEFTUP.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.UP.move();
			moveChack(sa, Move.point);
			Move.point.set(sa.getPosition());
			Move.LEFT.move();
			moveChack(sa, Move.point);
		}
		return points.getMovable();
	}

	private boolean moveChack(Piece sa, Point p) {
		tmp_piece = board.getPiece(p);
		if (tmp_piece == null) {
			points.add(p);
			return true;
		}
		if (sa.isTeam(tmp_piece)) {
			points.add(p);
		}
		return false;
	}
}
