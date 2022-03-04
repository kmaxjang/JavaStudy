package com.exproject.janggi.util;

// 좌표
public class Point {

	public int x = 0;
	public int y = 0;

	public boolean chack = true; // 이동가능 체크

	public Point() {
		this(0, 0);
	}

	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point set(Point p) {
		set(p.x, p.y);
		return this;
	}

	public Point set(String number) {
		int num = Integer.parseInt(number);
		x = num / 10;
		y = num % 10;
		return this;
	}

	public Point set(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Point get() {
		return new Point(this);
	}

	public boolean equals(Point p) {
		return (x == p.x && y == p.y);
	}

	public boolean equals(int x, int y) {
		return (this.x == x && this.y == y);
	}

	public String toString() {
		return "" + x + y;
	}
}
