package com.game.janggi.ex4;

import java.util.Iterator;

import com.game.janggi.ex2.tool.Point;

public interface Board {

    public int min_x = 0;
    public int max_x = 9;
    public int min_y = 0;
    public int max_y = 10;

    public Move[] way = { Move.UP, Move.UR, Move.RT, Move.DR, Move.DW, Move.DL, Move.LT, Move.UL };
    public Point[] castle = { //
	    new Point(5, 0), new Point(5, 2), new Point(3, 2), new Point(3, 0), //
	    new Point(4, 1), //
	    new Point(5, 7), new Point(5, 9), new Point(3, 9), new Point(3, 7), //
	    new Point(4, 8) }; //

    public Group isTurn();

    public boolean isPieceCheck(Point position);

    public Piece getPiece(Point position);

    public Iterator<Piece> getNowPiece();

    public Point getListPiece();

    public int getCount();
}

interface Piece {

    public Group getGroup();

    public PieceName getName();

    public int getCode();

    public Point getPoint();

    public boolean setMove(Point movepoint);

    public Iterator<Point> getMovable();

    public boolean equals(Group group);

    public boolean equals(PieceName piece);
}

enum Group {
    Han(10, true), Cho(20, false);

    private final int code;
    private final boolean group;

    private Group(int code, boolean group) {
	this.code = code;
	this.group = group;
    }

    public int getCode() {
	return code;
    }

    public boolean isGroup() {
	return group;
    }
}

enum PieceName {
    King(1), Cha(2), Poo(3), Ma(4), Sang(5), Sa(6), Jol(7);

    private final int code;;

    private PieceName(int code) {
	this.code = code;
	;
    }

    public int getCode() {
	return code;
    }
}

enum Move {
    UL(-1, -1), UP(0, -1), UR(1, -1), //
    LT(-1, 0), /*        */ RT(1, 0), //
    DL(-1, 1), DW(0, 1), DR(1, 1); //

    private Point move;
    private Point movepoint = new Point();

    private Move(int x, int y) {
	move = new Point(x, y);
    }

    public Point getPoint() {
	return movepoint;
    }

    public Move set(Point nowpoint) {
	movepoint.set(nowpoint.x + move.x, nowpoint.y + move.y);
	return this;
    }

    public boolean isBoardOutCheck(Point nowpoint) {
	movepoint.set(nowpoint.x + move.x, nowpoint.y + move.y);
	switch (this) {
	case UP:
	    return (movepoint.y > Board.min_y);
	case UR:
	    return (movepoint.y > Board.min_y && movepoint.x < Board.max_x);
	case RT:
	    return (movepoint.x < Board.max_x);
	case DR:
	    return (movepoint.y < Board.max_y && movepoint.x < Board.max_x);
	case DW:
	    return (movepoint.y < Board.max_y);
	case DL:
	    return (movepoint.y < Board.max_y && movepoint.x > Board.min_x);
	case LT:
	    return (movepoint.x > Board.min_x);
	case UL:
	    return (movepoint.y > Board.min_y && movepoint.x > Board.min_x);
	}
	return false;
    }
}
