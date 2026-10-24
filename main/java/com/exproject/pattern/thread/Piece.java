package com.exproject.pattern.thread;

import java.util.Arrays;

public class Piece {

	private String[] pieceinfo;
	
	public Piece(String piece) {
		pieceinfo = piece.split("");
	}
	
	public String teamName() {
		return (pieceinfo[0].equals("1"))?"한":"초";
	}
	
	public boolean teamBoolean() {
		return (pieceinfo[0].equals("1"))? true: false;
	}
	
	public String className() {
		switch(pieceinfo[1]) {
		case "1" : return "차";
		case "2" : return "포";
		case "3" : return "마";
		case "4" : return "상";
		case "5" : return "사";
		case "6" : return teamBoolean()?"졸":"병";
		case "7" : return "왕";		
		}
		return null;
	}
	
	public int getX() {
		return Integer.parseInt(pieceinfo[2]);
	}
	
	public int getY() {
		return Integer.parseInt(pieceinfo[3]);
	}
		
	public String string(int p) {
		return pieceinfo[p];
	}
	
	public int parse(int p) {
		return Integer.parseInt(pieceinfo[p]);
	}
	
	public String info() {
		return Arrays.toString(pieceinfo);
	}
	
	public boolean move(int movex, int movey) {
		pieceinfo[2] = Integer.valueOf(movex).toString();
		pieceinfo[3] = Integer.valueOf(movey).toString();
		return true;
	}	
}
