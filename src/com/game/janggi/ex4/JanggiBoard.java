package com.jjanggi2;
import java.awt.Point;
import java.util.Iterator;
import java.util.List;

public class JanggiBoard implements Board {
	/*
	 * ����� �迭
	 */
	private boolean playflag = false; // ��� ����

	/*
	 * �� ���
	 */
	private Chess[] chesslist = new Chess[32];

	/*
	 * ���� �ڸ� ��ġ
	 */
	private int[][] msms = { { 1, 2, 6, 7 }, // ���󸶻�
			{ 1, 2, 7, 6 }, // �����
			{ 2, 1, 6, 7 }, // �󸶸���
			{ 2, 1, 7, 6 } };// �󸶻�

	public JanggiBoard() {

		setDefaultBoard(null, 1, 1);

	}

	@Override
	public Chess getChess(Point position) {
		return board[position.x][position.y];
	}

	public List<Point> moveCheck(Chess chess) {

		return null;
	}

	public void setDefaultBoard(Chess[] newchesslist, int tms, int fms) {

		chesslist[0] = new JangChess(this, true, Chess.type.CH, new Point(0, 0));
		chesslist[1] = new JangChess(this, true, Chess.type.SA, new Point(3, 0));
		chesslist[2] = new JangChess(this, true, Chess.type.SA, new Point(5, 0));
		chesslist[3] = new JangChess(this, true, Chess.type.CH, new Point(8, 0));
		chesslist[4] = new JangChess(this, true, Chess.type.KG, new Point(4, 1));
		chesslist[5] = new JangChess(this, true, Chess.type.PO, new Point(1, 2));
		chesslist[6] = new JangChess(this, true, Chess.type.PO, new Point(7, 2));
		chesslist[7] = new JangChess(this, true, Chess.type.JU, new Point(0, 3));
		chesslist[8] = new JangChess(this, true, Chess.type.JU, new Point(2, 3));
		chesslist[9] = new JangChess(this, true, Chess.type.JU, new Point(4, 3));
		chesslist[10] = new JangChess(this, true, Chess.type.JU, new Point(6, 3));
		chesslist[11] = new JangChess(this, true, Chess.type.JU, new Point(8, 3));

		chesslist[12] = new JangChess(this, false, Chess.type.CH, new Point(0, 9));
		chesslist[13] = new JangChess(this, false, Chess.type.SA, new Point(3, 9));
		chesslist[14] = new JangChess(this, false, Chess.type.SA, new Point(5, 9));
		chesslist[15] = new JangChess(this, false, Chess.type.CH, new Point(8, 9));
		chesslist[16] = new JangChess(this, false, Chess.type.KG, new Point(4, 8));
		chesslist[17] = new JangChess(this, false, Chess.type.PO, new Point(1, 7));
		chesslist[18] = new JangChess(this, false, Chess.type.PO, new Point(7, 7));
		chesslist[19] = new JangChess(this, false, Chess.type.JU, new Point(0, 6));
		chesslist[20] = new JangChess(this, false, Chess.type.JU, new Point(2, 6));
		chesslist[21] = new JangChess(this, false, Chess.type.JU, new Point(4, 6));
		chesslist[22] = new JangChess(this, false, Chess.type.JU, new Point(6, 6));
		chesslist[23] = new JangChess(this, false, Chess.type.JU, new Point(8, 6));

		chesslist[24] = new JangChess(this, true, Chess.type.MA, new Point(msms[tms][0], 0));
		chesslist[25] = new JangChess(this, true, Chess.type.SN, new Point(msms[tms][1], 0));
		chesslist[26] = new JangChess(this, true, Chess.type.MA, new Point(msms[tms][2], 0));
		chesslist[27] = new JangChess(this, true, Chess.type.SN, new Point(msms[tms][3], 0));

		chesslist[28] = new JangChess(this, false, Chess.type.MA, new Point(msms[fms][0], 9));
		chesslist[29] = new JangChess(this, false, Chess.type.SN, new Point(msms[fms][1], 9));
		chesslist[30] = new JangChess(this, false, Chess.type.MA, new Point(msms[fms][2], 9));
		chesslist[31] = new JangChess(this, false, Chess.type.SN, new Point(msms[fms][3], 9));

		for (int x = 0; board.length > x; x++) {
			for (int y = 0; board[0].length > y; y++) {
				board[x][y] = null;
			}
		}

		for (int x1 = 0; chesslist.length > x1; x1++) {
			System.out.println(" " + chesslist[x1].isTeams() + " " + chesslist[x1].getType() + " "
					+ chesslist[x1].getNowPosition());

			Point p = chesslist[x1].getNowPosition();
			board[p.x][p.y] = chesslist[x1];
		}

		for (int x = 0; board.length > x; x++) {
			for (int y = 0; board[0].length > y; y++) {
				if (board[x][y] == null) {
					System.out.print("    ");
				} else {
					System.out.print(board[x][y].getType());
				}
			}
			System.out.println("");
		}
	}

	public static void main(String arg[]) {

		Board board = new JanggiBoard();
		Chess[] chess = board.getAllChess();

		List<Point> list = chess[6].getMoveList();
		if (list != null) {
			System.out.println("�̵�" + list.size());
			Iterator<Point> ip = list.iterator();
			while (ip.hasNext()) {
				System.out.println(ip.next());
			}
		}

	}

	@Override
	public Chess[] getAllChess() {

		return chesslist;
	}

	@Override
	public boolean isCheck(Point position) {
		return (board[position.x][position.y] != null) ? true : false;
	}

	@Override
	public void setChess(Chess chess) {

	}

}
