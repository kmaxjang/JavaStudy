package com.exproject.janggi.util;

import java.util.Iterator;

// 좌표들 기역
public class Points {

	private Point[] list; // 좌표들
	private int limet = 0; // 현재용량

	public Points(int capacity) {
		if (capacity < 5) {
			capacity = 5;
		} else if (capacity > 21) {
			capacity = 21;
		}
		list = new Point[capacity];
	}

	public int limet() {
		return limet;
	}

	public boolean add(Point p) {
		if (limet < list.length) {
			list[limet] = p.get();
			limet++;
			return true;
		}
		return false;
	}

	public boolean add(int x, int y) {
		if (limet < list.length) {
			list[limet] = new Point(x, y);
			limet++;
			return true;
		}
		return false;
	}
	
	public boolean comper(Point p) {
		for(int i = 0; i < limet; i++) {
			if(list[i].equals(p)) {
				return true;
			}
		}
		return false;
	}

	public Iterator<Point> getMovable() {
		return new Iterator<Point>() {
			
			private int count = limet;			
			private Point[] iter;
			{
				System.arraycopy(list, 0, iter, 0, count);
			}
			
			@Override
			public boolean hasNext() {
				return (count > 0);
			}
			
			@Override
			public Point next() {
				count--;
				return iter[count];
			}
		};
	}

	public void clear() {
		limet = 0;
	}
	
	public String toString() {
		return "Length :"+list.length+" limet :"+ limet;
	}
}