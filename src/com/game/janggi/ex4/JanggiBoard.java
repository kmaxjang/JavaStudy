package com.game.janggi.ex4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.game.janggi.ex2.tool.Point;

public class JanggiBoard implements Board {

    private Group turn = Group.Cho;
    private List<Piece> piecelist = new ArrayList<>();
    private Piece[][] board = new Piece[Board.max_x][Board.max_y];

    private int[][] msms = { { 1, 2, 6, 7 }, //
	    { 1, 2, 7, 6 }, //
	    { 2, 1, 6, 7 }, //
	    { 2, 1, 7, 6 } };

    public JanggiBoard() {
	reset();
	setDefaultBoard(1, 1);

    }

    private void reset() {
	for (int y = 0; y < board[0].length; y++) {
	    for (int x = 0; x < board.length; x++) {
		board[x][y] = null;
	    }
	}
    }

    public void setDefaultBoard(int tms, int fms) {

	piecelist.add(new JangChess(this, Group.Han, PieceName.Cha, new Point(0, 0)));
	piecelist.add(new JangChess(this, Group.Han, PieceName.Sa, new Point(3, 0)));
	piecelist.add(new JangChess(this, Group.Han, PieceName.Sa, new Point(5, 0)));
	piecelist.add(new JangChess(this, Group.Han, PieceName.Cha, new Point(8, 0)));
	piecelist.add(new JangChess(this, Group.Han, PieceName.King, new Point(4, 1)));
	piecelist.add(new JangChess(this, Group.Han, PieceName.Poo, new Point(1, 2)));
	piecelist.add(new JangChess(this, Group.Han, PieceName.Poo, new Point(7, 2)));
	piecelist.add(new JangChess(this, Group.Han, PieceName.Jol, new Point(0, 3)));
	piecelist.add(new JangChess(this, Group.Han, PieceName.Jol, new Point(2, 3)));
	piecelist.add(new JangChess(this, Group.Han, PieceName.Jol, new Point(4, 3)));
	piecelist.add(new JangChess(this, Group.Han, PieceName.Jol, new Point(6, 3)));
	piecelist.add(new JangChess(this, Group.Han, PieceName.Jol, new Point(8, 3)));

	piecelist.add(new JangChess(this, Group.Cho, PieceName.Cha, new Point(0, 9)));
	piecelist.add(new JangChess(this, Group.Cho, PieceName.Sa, new Point(3, 9)));
	piecelist.add(new JangChess(this, Group.Cho, PieceName.Sa, new Point(5, 9)));
	piecelist.add(new JangChess(this, Group.Cho, PieceName.Cha, new Point(8, 9)));
	piecelist.add(new JangChess(this, Group.Cho, PieceName.King, new Point(4, 8)));
	piecelist.add(new JangChess(this, Group.Cho, PieceName.Poo, new Point(1, 7)));
	piecelist.add(new JangChess(this, Group.Cho, PieceName.Poo, new Point(7, 7)));
	piecelist.add(new JangChess(this, Group.Cho, PieceName.Jol, new Point(0, 6)));
	piecelist.add(new JangChess(this, Group.Cho, PieceName.Jol, new Point(2, 6)));
	piecelist.add(new JangChess(this, Group.Cho, PieceName.Jol, new Point(4, 6)));
	piecelist.add(new JangChess(this, Group.Cho, PieceName.Jol, new Point(6, 6)));
	piecelist.add(new JangChess(this, Group.Cho, PieceName.Jol, new Point(8, 6)));

	piecelist.add(new JangChess(this, Group.Han, PieceName.Ma, new Point(msms[tms][0], 0)));
	piecelist.add(new JangChess(this, Group.Han, PieceName.Sang, new Point(msms[tms][1], 0)));
	piecelist.add(new JangChess(this, Group.Han, PieceName.Ma, new Point(msms[tms][2], 0)));
	piecelist.add(new JangChess(this, Group.Han, PieceName.Sang, new Point(msms[tms][3], 0)));

	piecelist.add(new JangChess(this, Group.Cho, PieceName.Ma, new Point(msms[fms][0], 9)));
	piecelist.add(new JangChess(this, Group.Cho, PieceName.Sang, new Point(msms[fms][1], 9)));
	piecelist.add(new JangChess(this, Group.Cho, PieceName.Ma, new Point(msms[fms][2], 9)));
	piecelist.add(new JangChess(this, Group.Cho, PieceName.Sang, new Point(msms[fms][3], 9)));

	piecelist.add(new JangChess(this, Group.Cho, PieceName.Sang, new Point(3, 7)));

	for (int x1 = 0; piecelist.size() > x1; x1++) {
	    System.out.println("Code " + piecelist.get(x1).getCode() + " Group " + piecelist.get(x1).getGroup()
		    + " Point" + piecelist.get(x1).getPoint());
	    Point p = piecelist.get(x1).getPoint();
	    board[p.x][p.y] = piecelist.get(x1);
	}

	for (int y = 0; y < board[0].length; y++) {
	    for (int x = 0; x < board.length; x++) {
		if (board[x][y] == null) {
		    System.out.print("00 ");
		} else {
		    System.out.print(board[x][y].getCode() + " ");
		}
	    }
	    System.out.println("완료");
	}
    }

    public static void main(String arg[]) {

	Board board = new JanggiBoard();
	Iterator<Piece> chess = board.getNowPiece();
	while (chess.hasNext()) {
	    Iterator<Point> movable = chess.next().getMovable();
	    if (movable != null) {
		System.out.print("이동 ");
		while (movable.hasNext()) {
		    System.out.print(movable.next() + " ");
		}
		System.out.println();
	    }
	}

    }

    @Override
    public boolean isPieceCheck(Point position) {
	return board[position.x][position.y] != null;
    }

    @Override
    public Group isTurn() {
	return turn;
    }

    @Override
    public Piece getPiece(Point position) {
	return board[position.x][position.y];
    }

    @Override
    public Iterator<Piece> getNowPiece() {
	return piecelist.iterator();
    }

    @Override
    public int getCount() {
	return 0;
    }

    @Override
    public Point getListPiece() {	
	return null;
    }
}
