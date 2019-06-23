package com.exproject.janggi.util;

import java.util.Iterator;

// 좌표들 기역
public class Points {
    
    private Point[] points; // 좌표들
    private int limet = 0; // 현재용량
    
    public Points( int capacity ) {
	if( capacity < 5 ){
	    capacity = 5;
	}else if( capacity > 21 ){
	    capacity = 21;
	}
	points = new Point[capacity];
	for( int i = 0; i < points.length; i++ ){
	    points[i] = new Point();
	}
    }
    
    public int limet(){
	return limet;
    }
    
    public boolean add( Point p ){
	return add(p.x, p.x);
    }
    
    public boolean add( int x, int y ){
	if( limet < points.length ){
	    points[limet].set(x, y);
	    limet++;
	    return true;
	}
	return false;
    }
    
    public Iterator<Point> getMovable(){
	return new Iterator<Point>(){
	    private int count = limet;
	    
	    public boolean hasNext(){
		return(count > 0);
	    }
	    
	    public Point next(){
		count--;
		return points[count];
	    }
	};
    }
    
    public void clear(){
	limet = 0;
    }
}