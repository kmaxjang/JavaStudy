package com.game2.state;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import com.game2.map.Background;


public class MenuState extends GameState {
	
	private Background bg;
	
	private int currentchoice =0;
	private String[] options ={
			"Start",
			"Help",
			"Quit"
	};
	
	private Color titlecolor;
	private Font titlefont;
	
	private Font font;
	
	public MenuState(GameStateManager gsm){
		this.gsm = gsm;
		
		bg = new Background("/game/backgrounds/menubg.gif",1);
		bg.setVector(0, 0);
		
		titlecolor = new Color(128,0,0);
		titlefont = new Font(
				"Century Gothic",
				Font.PLAIN,
				28
				);
		font = new Font(
				"Arial",
				Font.PLAIN,
				12
				);
		
		
	}
	
	public void init(){
		
	}
	
	public void update(){
		bg.updata();
	}
	
	public void draw(java.awt.Graphics2D g){
		bg.draw(g);
		g.setColor(titlecolor);
		g.setFont(titlefont);
		g.drawString("Dragon Tale", 80, 70);
		
		g.setFont(font);
		for(int i =0; i < options.length; i++){
			if(i == currentchoice){
				g.setColor(Color.BLACK);
			}else{
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 145, 140+i*15);
		}		
	}
	
	public void keyPressed(int k){
		if(k == KeyEvent.VK_ENTER){
			select();
		}
		if(k == KeyEvent.VK_UP){
			currentchoice--;
			if(currentchoice == -1)
				currentchoice = options.length -1;
		}
		if(k == KeyEvent.VK_DOWN){
			currentchoice++;
			if(currentchoice == options.length)
				currentchoice =0;
		}
	}
	
	private void select() {
		switch(currentchoice){
		case 0: gsm.setState(GameStateManager.LEVEL1STATE); break;
		case 1: break;
		case 3:
			System.exit(0);			
		}		
	}

	public void keyReleased(int k){
		
	}

}
