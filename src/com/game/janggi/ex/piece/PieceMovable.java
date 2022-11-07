package com.exproject.janggi.piece;

import java.util.ArrayList;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public abstract class PieceMovable {
    
    private Board board;
    private Points points = new Points(21);;
    private Piece tmp_piece;
    
    public PieceMovable(Board board) {
	this.board = board;
    }
    
    
}
