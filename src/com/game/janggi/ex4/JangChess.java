package com.game.janggi.ex4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.game.janggi.ex2.tool.Point;

public class JangChess implements Piece {

    private final Group group;
    private final PieceName piece;
    private final Point position = new Point();

    private final Board board;
    private List<Point> movable_list = new ArrayList<Point>();
    private boolean flag = true;
//    public final Move[] way = { UP, UR, RT, DR, DW, DL, LT, UL };
   
    private Point tmp = new Point();

    public JangChess(Board board, Group group, PieceName piece, Point position) {
	this.board = board;
	this.group = group;
	this.piece = piece;
	this.position.set(position);
    }

    private int moveAdd(Point point) {
	if (janggun()) {
	//    return 4;
	}
	if (board.isPieceCheck(point)) {
	    if (!board.getPiece(point).equals(group)) {
		// kill add list
		movable_list.add(point.get());
		return 1;
	    }
	    // no list
	    return 3;
	}
	// space add list
	movable_list.add(point.get());
	return 0;
    }

    private void getMoveList() {
	movable_list.clear();

//	System.out.println("Code" + getCode() + " Group" + getGroup() + " Piece" + getName() + " Point" + getPoint());
//	int start = 0; // 시작지점
//	int add = 2; // 증가분
//	int ro = 8; // 회전 범위
//	for (int i = start; i < start + ro; i += add) {
//	    System.out.print(" " + way[i % ro]);
//	}

	switch (piece) {
	case King:
	case Sa:
	    int sa = 0;
	    if (Board.castle[0].equals(position) || Board.castle[5].equals(position)) {
		sa = 4;
	    } else if (Board.castle[1].equals(position) || Board.castle[6].equals(position)) {
		sa = 6;
	    } else if (Board.castle[2].equals(position) || Board.castle[7].equals(position)) {
		sa = 0;
	    } else if (Board.castle[3].equals(position) || Board.castle[8].equals(position)) {
		sa = 2;
	    } else if (Board.castle[4].equals(position) || Board.castle[9].equals(position)) {
		// 궁 중앙
		for (int p = 0; p < Board.way.length; p++) {
		    Board.way[p].set(position);
		    moveAdd(Board.way[p].getPoint());
		}
		break;
	    }
	    for (int p = sa; p < sa + 3; p++) {
		Move m = Board.way[p % 8];
		m.set(position);
		moveAdd(m.getPoint());
	    }
	    break;
	case Jol:
	    int[] set = (group.isGroup()) ? new int[] { 2, 5, 8, 9, 6, 7 } : new int[] { 6, 1, 2, 4, 0, 3 };
	    for (int p = set[0]; p < set[0] + 5; p += 2) {
		Move m = Board.way[p % 8];
		if (m.isBoardOutCheck(position)) {
		    moveAdd(m.getPoint());
		}
	    }
	    // 궁
	    if (Board.castle[set[1]].equals(position) || Board.castle[set[2]].equals(position)) {
		moveAdd(Board.castle[set[3]]);
	    } else if (Board.castle[set[3]].equals(position)) {
		moveAdd(Board.castle[set[4]]);
		moveAdd(Board.castle[set[5]]);
	    }
	    break;
	case Sang:
	    for (int p = 0, p2 = 0; p < Board.way.length; p += 2) {
		if (Board.way[p].isBoardOutCheck(position) && !board.isPieceCheck(Board.way[p].getPoint())) {
		    p2 = (p + 7) % 8;
		    if (Board.way[p2].isBoardOutCheck(Board.way[p].getPoint()) && !board.isPieceCheck(Board.way[p2].getPoint())
			    && Board.way[p2].isBoardOutCheck(Board.way[p2].getPoint())) {
			moveAdd(Board.way[p2].getPoint());
		    }
		    p2 = (p + 1) % 8;
		    if (Board.way[p2].isBoardOutCheck(Board.way[p].getPoint()) && !board.isPieceCheck(Board.way[p2].getPoint())
			    && Board.way[p2].isBoardOutCheck(Board.way[p2].getPoint())) {
			moveAdd(Board.way[p2].getPoint());
		    }
		}
	    }
	    break;
	case Ma:
	    for (int p = 0, p2 = 0; p < Board.way.length; p += 2) {
		if (Board.way[p].isBoardOutCheck(position) && !board.isPieceCheck(Board.way[p].getPoint())) {
		    p2 = (p + 7) % 8;
		    if (Board.way[p2].isBoardOutCheck(Board.way[p].getPoint())) {
			moveAdd(Board.way[p2].getPoint());
		    }
		    p2 = (p + 1) % 8;
		    if (Board.way[p2].isBoardOutCheck(Board.way[p].getPoint())) {
			moveAdd(Board.way[p2].getPoint());
		    }
		}
	    }
	    break;
	case Poo:
	    Move move;
	    for (int p = 0; p < Board.way.length; p += 2) {
		tmp.set(position);
		move = Board.way[p];
		while (move.isBoardOutCheck(tmp)) {
		    if (board.isPieceCheck(move.getPoint())) {
			if (!board.getPiece(move.getPoint()).equals(PieceName.Poo)) {
			    while (move.isBoardOutCheck(move.getPoint())) {
				if (board.isPieceCheck(move.getPoint())) {
				    Piece piecetmp = board.getPiece(move.getPoint());
				    if (!piecetmp.equals(group) && !piecetmp.equals(PieceName.Poo)) {
					// kill add list
					movable_list.add(move.getPoint().get());
				    }
				    break;
				}
				// space add list
				movable_list.add(move.getPoint().get());
			    }
			}
			break;
		    }
		    tmp.set(move.getPoint());
		}
	    }
	    // 궁
	    if (Board.castle[0].equals(position) || Board.castle[5].equals(position)) {
		move = Move.DL;
	    } else if (Board.castle[1].equals(position) || Board.castle[6].equals(position)) {
		move = Move.UL;
	    } else if (Board.castle[2].equals(position) || Board.castle[7].equals(position)) {
		move = Move.UR;
	    } else if (Board.castle[3].equals(position) || Board.castle[8].equals(position)) {
		move = Move.DR;
	    } else {
		break;
	    }
	    move.set(position);
	    if (board.isPieceCheck(move.getPoint()) && !board.getPiece(move.getPoint()).equals(PieceName.Poo)) {
		move.set(move.getPoint());
		if (board.isPieceCheck(move.getPoint())) {
		    if (!board.getPiece(move.getPoint()).equals(group)
			    && !board.getPiece(move.getPoint()).equals(PieceName.Poo)) {
			// kill add list
			movable_list.add(move.getPoint().get());
		    }
		} else {
		    // space add list
		    movable_list.add(move.getPoint().get());
		}
	    }
	    break;
	case Cha:
	    for (int p = 0; p < Board.way.length; p += 2) {
		tmp.set(position);
		move = Board.way[p];
		while (move.isBoardOutCheck(tmp)) {
		    if (moveAdd(move.getPoint()) != 0) {
			break;
		    }
		    tmp.set(move.getPoint());
		}
	    }
	    // 궁
	    if (Board.castle[0].equals(position) || Board.castle[5].equals(position)) {
		move = Move.DL;
	    } else if (Board.castle[1].equals(position) || Board.castle[6].equals(position)) {
		move = Move.UL;
	    } else if (Board.castle[2].equals(position) || Board.castle[7].equals(position)) {
		move = Move.UR;
	    } else if (Board.castle[3].equals(position) || Board.castle[8].equals(position)) {
		move = Move.DR;
	    } else if (Board.castle[4].equals(position) || Board.castle[9].equals(position)) {
		for (int p = 1; p < Board.way.length; p += 2) {
		    moveAdd(Board.way[p].set(position).getPoint());
		}
		break;
	    } else {
		break;
	    }
	    move.set(position);
	    if (moveAdd(move.getPoint()) == 0) {
		moveAdd(move.set(move.getPoint()).getPoint());
	    }
	    break;
	}
    }

    private boolean janggun() {
	Point king = new Point(4,1);
	Move move;
	Piece piece;
	for (int p = 0; p < Board.way.length; p += 2) {
	    tmp.set(king);
	    move = Board.way[p];
	    while (move.isBoardOutCheck(tmp)) {
		if (board.isPieceCheck(move.getPoint())) {
		    piece = board.getPiece(move.getPoint());
		    if (!piece.equals(group) && piece.equals(PieceName.Cha)) {
			// add Cha Jang;
			System.out.println("Cha Jang");
		    }
		    if (!piece.equals(PieceName.Poo)) {
			tmp.set(move.getPoint());
			while (move.isBoardOutCheck(tmp)) {
			    if (board.isPieceCheck(tmp)) {
				piece = board.getPiece(tmp);
				if (!piece.equals(group) && piece.equals(PieceName.Poo)) {
				    // add Poo Jang;
				    System.out.println("Poo Jang");
				    break;
				}
			    }
			    tmp.set(move.getPoint());
			}
		    }
		    break;
		}
		tmp.set(move.getPoint());
	    }
	}

	for (int p = 0, p2 = 0; p < Board.way.length; p += 2) {
	    if (Board.way[p].isBoardOutCheck(position) && !board.isPieceCheck(Board.way[p].getPoint())) {
		for (int i = 1; i <= 7; i += 6) {
		    p2 = (p + i) % 8;
		    if (Board.way[p2].isBoardOutCheck(Board.way[p].getPoint())) {
			if (board.isPieceCheck(Board.way[p2].getPoint())) {
			    if (Board.way[p2].isBoardOutCheck(Board.way[p2].getPoint()) && !board.isPieceCheck(Board.way[p2].getPoint())
				    && board.getPiece(Board.way[p2].getPoint()).equals(PieceName.Sang)) {
				// add Sang Jang
				System.out.println("Sang Jang");
			    }
			} else if (board.getPiece(Board.way[p2].getPoint()).equals(PieceName.Ma)) {
			    // add Ma Jang
			    System.out.println("Ma Jang");
			}
		    }
		}
	    }
	}
	return false;
    }

    @Override
    public Group getGroup() {
	return group;
    }

    @Override
    public PieceName getName() {
	return piece;
    }

    @Override
    public int getCode() {
	return group.getCode() + piece.getCode();
    }

    @Override
    public Point getPoint() {
	return position.get();
    }

    @Override
    public boolean setMove(Point movepoint) {
	flag = true;
	return false;
    }

    @Override
    public Iterator<Point> getMovable() {
	if (flag) {
	    getMoveList();
	    flag = false;
	}
	return movable_list.iterator();
    }

    @Override
    public boolean equals(Group group) {
	return this.group.equals(group);
    }

    @Override
    public boolean equals(PieceName piece) {
	return this.piece.equals(piece);
    }
}
