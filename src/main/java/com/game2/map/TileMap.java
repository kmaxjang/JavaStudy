package com.game2.map;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import com.game2.Config;

public class TileMap {

	private double x;
	private double y;
	
	private int xmin;
	private int ymin;
	private int xmax;
	private int ymax;
	
	private double tween;
	
	private int[][] map;
	private int tilesize;
	private int numrows;
	private int numcols;
	private int width;
	private int height;
	
	private BufferedImage tileset;
	private int numtilesacross;
	private Tile[][] tiles;
	
	private int rowoffset;
	private int coloffset;
	private int numrowstodraw;
	private int numcolstodraw;
	
	public TileMap(int tilesize){
		this.tilesize = tilesize;
		numrowstodraw = Config.HEIGHT / tilesize+2;
		numcolstodraw = Config.WIDTH / tilesize+2;
		
		tween = 0.07;
	}
	
	public void loadTiles(String s) throws IOException{

		tileset = ImageIO.read(getClass().getResourceAsStream(s));
		
		numtilesacross = tileset.getWidth()/ tilesize;
		tiles = new Tile[2][numtilesacross];
		
		BufferedImage subimage;
		for(int col =0; col < numtilesacross; col++){
			subimage = tileset.getSubimage(
					col*tilesize,
					0,
					tilesize,
					tilesize
					);
			tiles[0][col] = new Tile(subimage, Tile.NORMAL);
			subimage = tileset.getSubimage(
					col * tilesize,
					tilesize,
					tilesize,
					tilesize
					);
			tiles[1][col] = new Tile(subimage, Tile.BLOCKED);		
		}
	}
	
	public void loadMap(String s) throws NumberFormatException, IOException{
		
		
		InputStream in = getClass().getResourceAsStream(s);
		BufferedReader br = new BufferedReader( new InputStreamReader(in));
				
		numcols = Integer.parseInt(br.readLine());
		numrows = Integer.parseInt(br.readLine());
		
		width = numcols* tilesize;
		height = numrows* tilesize;
		System.out.println("width"+ numcols+" height"+numrows);
		String delims = "\\s+";
		map = new int[numrows][numcols];
		for(int row =0; row< numrows; row++){
			String line = br.readLine();
			String [] tokens = line.split(delims);
			System.out.println(line+tokens.length);
			for(int col =0; col < numcols; col++){
				System.out.println("tokens["+col+"] ="+tokens[col]);
				map[row][col] = Integer.parseInt(tokens[col]);
				
			}
		}
		br.close();
		in.close();
				
	}
	
	public int getTileSize(){return tilesize;}
	public int getx(){ return (int)x;}
	public int gety(){ return (int)y;}
	public int getWidth(){ return width;}
	public int getHeight(){ return height;}
	
	public int getType(int row, int col){
		int rc = map[row][col];
		int r = rc/ numtilesacross;
		int c = rc% numtilesacross;
		return tiles[r][c].getType();
	}
	
	public void setPosition(double x, double y){
		this.x += (x - this.x)* tween;
		this.y += (y - this.y)* tween;
		fixBounds();
		coloffset =(int)-this.x / tilesize;
		rowoffset =(int)-this.y / tilesize;
	}
	
	private void fixBounds(){
		if(x < xmin) x = xmin;
		if(x > xmax) x = xmax;
		if(y < ymin) y = ymin;
		if(y > ymax) y = ymax;
	}
	
	public void draw(Graphics2D g){
		
		for(int row = rowoffset;
				row < rowoffset + numrowstodraw;
				row++){
			if(row >= numrows) break;
			for(int col = coloffset;
					col < coloffset+ numcolstodraw;
					col++){
				if(col >= numcols) break;
				if(map[row][col] == 0) continue;
				int rc = map[row][col];
				int r = rc / numtilesacross;
				int c = rc % numtilesacross;
				g.drawImage(
						tiles[r][c].getImage(),
						(int)x +col * tilesize,
						(int)y +row * tilesize,
						null);
			}			
		}		
	}
}
