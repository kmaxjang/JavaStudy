package com.game2.map;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.game2.Config;

public class Background {

	private BufferedImage image;
	
	private double x;
	private double y;
	private double dx;
	private double dy;
	
	private double movescale;
	
	public Background(String s, double ms){
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(s));
			movescale = ms;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setPosition(double x, double y){
		this.x = (x * movescale) % Config.WIDTH;
		this.y = (y * movescale) % Config.HEIGHT;
	}
	
	public void setVector(double dx, double dy){
		this.dx = dx;
		this.dy = dy;
	}
	
	public void updata(){
		x += dx;
		y += dy;
	}
	
	public void draw(java.awt.Graphics2D g){
		g.drawImage(image,(int)x, (int)y, null);
		if(x<0){
			g.drawImage(image,(int)x+Config.WIDTH, (int)y, null);
		}
		if(x>0){
			g.drawImage(image,(int)x-Config.WIDTH, (int)y, null);
		}
	}
}
