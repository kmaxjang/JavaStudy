package com.exproject.janggi.util;

// 좌표

public class Point {
    
    public int x;
    public int y;    
    
    public boolean chack = true; // 이동가능 체크
    
    public Point() {
	this(0, 0);
    }
    
    public Point( int x, int y ) {
	this.x = x;
	this.y = y;
    }
    
    public void set( Point p ){
	set(p.x, p.y);
    }
    
    public void set( int x, int y ){
	this.x = x;
	this.y = y;
    }
    
    public Point get(){
	return this;
    }    
    
    public boolean equals( Point p ){
	return equals(p.x, p.y);
    }
    
    public boolean equals( int x, int y ){
	return(this.x == x && this.y == y);
    }
}
