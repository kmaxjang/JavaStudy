package com.game2;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.game2.state.GameStateManager;

public class GamePanel 
extends JPanel
implements Runnable, KeyListener{

private static final long serialVersionUID = 1L;

private Thread thread;
private boolean running;
private long FPS =60;
private long targetTime = 1000/FPS;

private BufferedImage image;
private Graphics2D g;

private GameStateManager gsm;

public GamePanel(){
	super();
	setPreferredSize(new Dimension(Config.WIDTH* Config.SCALE, Config.HEIGHT * Config.SCALE));
	setFocusable(true);
	requestFocus();
}

public void addNotify(){
	super.addNotify();
	if(thread == null){
		thread = new Thread(this);
		this.addKeyListener(this);
		thread.start();
	}		
}

private void init(){
	image = new BufferedImage(
			Config.WIDTH, Config.HEIGHT,
			BufferedImage.TYPE_INT_RGB
			);
	g =(Graphics2D)image.createGraphics();
	running = true;
	gsm = new GameStateManager();
}

public void run(){
	init();
	
	long start=0;
	long elapsed=0;
	long wait=0;
	
	while(running){
		start = System.nanoTime();
		
		update();
		draw();
		g.drawString("Start"+start, 2, 10);
		g.drawString("Elapsed"+elapsed, 2, 20);
		g.drawString("FPS"+FPS+" //"+(elapsed / 1000000), 2, 30);
		g.drawString("Start"+start+"Elapsed"+elapsed, 2, 40);
		g.drawString("TargetTime"+targetTime+"Wait"+wait, 2, 50);				
		drawToScreen();
		
		elapsed = System.nanoTime() - start;
		wait = targetTime - elapsed / 1000000;
		if(wait < 0)
			wait = 5;
		
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

private void update(){
	gsm.updata();
}

private void draw(){
	gsm.draw(g);
}

private void drawToScreen(){
	Graphics g2 = getGraphics();
	g2.drawImage(image, 0, 0,Config.WIDTH*Config.SCALE, Config.HEIGHT*Config.SCALE, null);
	g2.dispose();
}


public void keyTyped(KeyEvent key){}
public void keyPressed(KeyEvent key){
	gsm.keyPressed(key.getKeyCode());
}
public void keyReleased(KeyEvent key){
	gsm.keyReleased(key.getKeyCode());
}
}