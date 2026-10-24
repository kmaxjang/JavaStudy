package com.exproject.pattern.observer;

import java.util.Iterator;

public final class Play { //implements PlayCommand{
	
	public Play() {

	}
	
	public boolean isTurn() {
		return false;
	}
	
	public boolean setPieceMove(Player player, String movepiece) {
		return false;
	}
	
	public Iterator<String> getPiecePatch() {
		return null;
	}
	
}
