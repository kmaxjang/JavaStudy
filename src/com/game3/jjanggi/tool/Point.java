package com.game3.jjanggi.tool;

// 좌표를 기억
public final class Point {

	public int x = 0;
	public int y = 0;

	public Point() {
		x = 0;
		y = 0;
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point set(Point p) {
		x = p.x;
		y = p.y;
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

	public Point move(Point p) {
		x += p.x;
		y += p.y;
		return this;
	}

	public Point move(int x, int y) {
		this.x += x;
		this.y += y;
		return this;
	}

	public boolean comper(Point p) {
		return (x == p.x && y == p.y);
	}

	public boolean comperx(int x) {
		return (this.x == x);
	}

	public boolean compery(int y) {
		return (this.y == y);
	}

	public Point getPoint() {
		return new Point(x, y);
	}

	public String toString() {
		return " " + x + y;
	}
}
