package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.PieceSet;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.PieceBuild;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class Poo extends Piece {

	private Board board;
	private Points points = new Points(14);
	private Point point = new Point();
	private Point oldpoint = new Point();
	private Name killname = null;
	private PieceSet tmp_piece;

	public Poo(Board board, PieceBuild piece) {
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
			while (way[w].scope()) {
				tmp_piece = board.getPiece(Move.point);
				if (tmp_piece != null) {
					if (!tmp_piece.equals(PieceSet.Name.POO)) {
						way[w].move();
						while (way[w].scope() && moveChack(Move.point)) {
							way[w].move();
						}
					}
					break;
				}
				way[w].move();
			}
		}
		Move.point.set(getPosition());
		if (Move.point.equals(board.castleup[1]) || Move.point.equals(board.castledown[1])) {
			castleWay(Move.LEFTDOWN);
		} else if (Move.point.equals(board.castleup[3]) || Move.point.equals(board.castledown[3])) {
			castleWay(Move.LEFTUP);
		} else if (Move.point.equals(board.castleup[5]) || Move.point.equals(board.castledown[5])) {
			castleWay(Move.RIGHTUP);
		} else if (Move.point.equals(board.castleup[7]) || Move.point.equals(board.castledown[7])) {
			castleWay(Move.RIGHTDOWN);
		}
	}

	private void castleWay(Move m) {
		m.move();
		tmp_piece = board.getPiece(Move.point);
		if (tmp_piece != null && !tmp_piece.equals(PieceSet.Name.POO)) {
			m.move();
			moveChack(Move.point);
		}
	}

	private boolean moveChack(Point p) {
		tmp_piece = board.getPiece(p);
		if (tmp_piece == null) {
			points.add(p);
			return true;
		}
		if (!tmp_piece.equals(PieceSet.Name.POO) && !tmp_piece.equals(getGroup())) {
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
