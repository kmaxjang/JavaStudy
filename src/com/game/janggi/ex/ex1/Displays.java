package com.game.janggi.ex.ex1;

import java.util.Iterator;
import com.game.janggi.ex.interfacemod.Piece;
import com.game.janggi.ex.util.Point;

//★Playername1 
//                (3) 05:00
//⬛⬛⬛⬛⬛⬛⬛⬛⬛
//⬛⬛⬛⬛⬛⬛⬛⬛⬛
//⬛⬛⬛⬛⬛⬛⬛⬛⬛
//⬛⬛⬛⬛⬛⬛⬛⬛⬛
//⬛⬛⬛⬛⬛⬛⬛⬛⬛
//⬛⬛⬛⬛⬛⬛⬛⬛⬛
//⬛⬛⬛⬛⬛⬛⬛⬛⬛
//                (3) 05:00
//☆Playname2 

public class Displays {

    private StringBuffer dot = new StringBuffer();
    private StringBuffer board = new StringBuffer();

    private String[] mark_turn = { "★", "☆" };
    private String[] mark_background = { "⬛", "□" };
    private String[] mark_movable = { "▣", "⭕" };

    private String[] player = { "player1", "player2" };
    public boolean turn = true;

    public Displays() {
	
	player(turn, player[0]);
	time(3, 5, 0);

	for (int y = 0; y < 10; y++) {
	    for (int x = 0; x < 9; x++) {
		board.append(mark_background[1]);
	    }
	    board.append("\n");
	}
	dot.append(board);

	time(3, 5, 0);
	player(!turn, player[1]);
    }

    private void player(boolean turn, String player) {
	dot.append(mark_turn[turn?0:1]);
	dot.append(" ");
	dot.append(player);
	dot.append("\n");	
    }
    
    private void time(int count, int minte, int sec) {
	dot.append("         ( ");
	dot.append(count);
	dot.append(" ) ");
	dot.append(String.format("%02d : %02d", minte, sec));
	dot.append("\n");	
    }

    private void reSetMovable() {

    }

    public void moveable(Iterator<Point> moves) {
	reSetMovable();
	if (moves != null) {
	    while (moves.hasNext()) {
		Point mp = moves.next();
		System.out.println("x" + mp.x + " y" + mp.y);
	    }
	}
	screen();
    }

    public void displaysUpdata(Iterator<Piece> iter) {

	while (iter.hasNext()) {
	    Piece piece = iter.next();
	    Point point = piece.getPosition();
	    System.out.println("정보"+point.toString() +" "+ board.length());	    
	    int re = point.x+point.y;
	    board.replace(re, re+1, getPieceMark(piece));
	    
	}
	screen();
    }

    private void screen() {
//	dot.delete(0, dot.capacity());		
	System.out.println(dot);
    }

    private String getPieceMark(Piece piece) {	
	if (piece != null) {
	    switch (piece.getTeam()) {
	    case HAN:
		switch (piece.getPieceName()) {
		case KING:
		    return "🦁";
		case CHA:
		    return "🐅";
		case POO:
		    return "🦌";
		case MA:
		    return "🐴";
		case SAG:
		    return "🐘";
		case SA:
		    return "🐀";
		case JOL:
		    return "🐵";
		}
	    case CHO:
		switch (piece.getPieceName()) {
		case KING:
		    return "🤴";
		case CHA:
		    return "👮‍♂️";
		case POO:
		    return "👨‍🚒";
		case MA:
		    return "👨‍🍳";
		case SAG:
		    return "👨‍🔧";
		case SA:
		    return "👨‍🏫";
		case JOL:
		    return "👨‍🌾";
		}
	    }
	}
	return mark_background[0];
    }

    public static void main(String[] args) {
	Displays ds = new Displays();
	Board exboard = new Board();

	ds.displaysUpdata(exboard.getPieceList());
	ds.screen();
    }
}
