package com.game2.state;

import java.util.ArrayList;

public class GameStateManager {
	
	private ArrayList<GameState> gamestates;
	private int currentstate;
	
	public static final int MENUSTATE =0;
	public static final int LEVEL1STATE =1;
	
	public GameStateManager(){
		
		gamestates = new ArrayList<GameState>();
		
		currentstate = MENUSTATE;
		gamestates.add(new MenuState(this));
		gamestates.add(new Level1(this));
	}
	
	public void setState(int state){
		currentstate = state;
		gamestates.get(currentstate).init();
	}
	
	public void updata(){
		gamestates.get(currentstate).update();
	}
	
	public void draw(java.awt.Graphics2D g){
		gamestates.get(currentstate).draw(g);
	}
	
	public void keyPressed(int k){
		gamestates.get(currentstate).keyPressed(k);
	}
	
	public void keyReleased(int k){
		gamestates.get(currentstate).keyReleased(k);
	}

}
