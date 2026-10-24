package com.game2.state;


import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import com.game2.Config;
import com.game2.map.TileMap;


public class Level1 extends GameState {
	
	private TileMap tilemap;
	
	
	
	public Level1(GameStateManager gsm){
		this.gsm = gsm;
		init();
	}

	public void init() {
		tilemap = new TileMap(10);
		try {
			tilemap.loadTiles("/game/tilesets/grasstileset.gif");
		} catch (IOException e) {
			System.out.println("�׸�����");
			e.printStackTrace();
		}
		try {
			tilemap.loadMap("/game/maps/level1-1.map");
		} catch (NumberFormatException e) {
			System.out.println("�ʾ���");
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		tilemap.setPosition(0, 0);	
	}

	@Override
	public void update() {
	
	}

	@Override
	public void draw(Graphics2D g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Config.WIDTH, Config.HEIGHT);
		tilemap.draw(g);
	
	}

	@Override
	public void keyPressed(int k) {
	
	}

	@Override
	public void keyReleased(int k) {
	
	}

}
