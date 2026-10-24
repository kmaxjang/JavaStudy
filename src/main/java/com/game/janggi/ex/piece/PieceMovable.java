package com.game.janggi.ex.piece;

import java.util.ArrayList;

import com.game.janggi.ex.Board;
import com.game.janggi.ex.interfacemod.Piece;
import com.game.janggi.ex.util.Point;
import com.game.janggi.ex.util.Points;

public abstract class PieceMovable {
    
    private Board board;
    private Points points = new Points(21);;
    private Piece tmp_piece;
    
    public PieceMovable(Board board) {
	this.board = board;
    }
    
    
}
