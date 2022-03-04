package com.exproject.janggi;

import java.util.ArrayList;
import java.util.Iterator;

import com.exproject.janggi.piece.Cha;
import com.exproject.janggi.piece.Jol;
import com.exproject.janggi.piece.King;
import com.exproject.janggi.piece.Ma;
import com.exproject.janggi.piece.Piece;
import com.exproject.janggi.piece.Poo;
import com.exproject.janggi.piece.Sa;
import com.exproject.janggi.piece.Sag;
import com.exproject.janggi.util.PieceBuild;
import com.exproject.janggi.util.Point;

public class Board {

	private Point tmp = new Point(0, 0);
	private PieceBuild pb = new PieceBuild();
	// 장기말 목록
	private ArrayList<Piece> piece_list = new ArrayList<Piece>();
	private ArrayList<String> orderlist = new ArrayList<String>();
	// 장기판 크기
	public final int MIN_X = 0;
	public final int MIN_Y = 0;
	public final int MAX_X = 9;
	public final int MAX_Y = 10;
	// 한 궁좌표
	public final Point[] castleup = {
	    new Point(4, 0),
	    new Point(5, 0),
	    new Point(5, 1),
	    new Point(5, 2),
	    new Point(4, 2),
	    new Point(3, 2),
	    new Point(3, 1),
	    new Point(3, 0),
	    new Point(4, 1)
	};
	// 초 궁좌표
	public final Point[] castledown = {
	    new Point(4, 7),
	    new Point(5, 7),
	    new Point(5, 8),
	    new Point(5, 9),
	    new Point(4, 9),
	    new Point(3, 9),
	    new Point(3, 8),
	    new Point(3, 7),
	    new Point(4, 8)
	};

	private int[] defaultpieceset = {
	    1700000,
	    1612120,
	    1330300,
	    1141410,
	    1350500,
	    1672720,
	    1780800,
	    1203030,
	    1223230,
	    1243430,
	    1263630,
	    1283830,
	    2709090,
	    2617170,
	    2339390,
	    2148480,
	    2359590,
	    2677770,
	    2789890,
	    2206060,
	    2226260,
	    2246460,
	    2266660,
	    2286860
	};

	public Board() {
		for (int pieceint : defaultpieceset) {
			pb.set(String.valueOf(pieceint));
			setPiece(pb);
		}

		int[] han = {
		    1410100,
		    1520200,
		    1460600,
		    1570700
		};
		int[] cho = {
		    2419190,
		    2529290,
		    2469690,
		    2579790
		};

		for (int pieceint : han) {
			pb.set(String.valueOf(pieceint));
			setPiece(pb);
		}

		for (int pieceint : cho) {
			pb.set(String.valueOf(pieceint));
			setPiece(pb);
		}
	}

	public Piece getPiece(int x, int y) {
		tmp.set(x, y);
		return index(tmp);
	}

	public Piece getPiece(Point p) {
		return index(p);
	}

	private Piece index(Point point) {
		for (Piece piece : piece_list) {
			if (piece.getPosition().equals(point)) {
				return piece;
			}
		}
		return null;
	}

	private void setPiece(PieceBuild piece) {
		switch (piece.getName()) {
		case CHA:
			piece_list.add(new Cha(this, piece));
			break;
		case POO:
			piece_list.add(new Poo(this, piece));
			break;
		case MA:
			piece_list.add(new Ma(this, piece));
			break;
		case SAG:
			piece_list.add(new Sag(this, piece));
			break;
		case SA:
			piece_list.add(new Sa(this, piece));
			break;
		case JOL:
			piece_list.add(new Jol(this, piece));
			break;
		case KING:
			piece_list.add(new King(this, piece));
			break;
		}
	}

	public Iterator<Piece> getPieceList() {
		return piece_list.iterator();
	}
}