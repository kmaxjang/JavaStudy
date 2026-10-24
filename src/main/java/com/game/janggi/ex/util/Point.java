package com.game.janggi.ex.util;

// 좌표

public class Point {

    public int x;
    public int y;

    public static int count = 0; // 임시 생성자 갯수 카운터 체크
    public boolean chack = true; // 이동가능 체크

    public Point() {
	this(0, 0);
    }

    public Point(int x, int y) {
	this.x = x;
	this.y = y;
	count++;
    }

    public void set(Point p) {
	set(p.x, p.y);
    }

    public void set(int x, int y) {
	this.x = x;
	this.y = y;
    }

    public void setX(int x) {
	this.x = x;
    }

    public void setY(int y) {
	this.y = y;
    }

    public void set(String number) {
	char[] num = number.toCharArray();
	x = num[0];
	y = num[1];
    }

    public Point get() {
	return this;
    }

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    public boolean equals(Point p) {
	return equals(p.x, p.y);
    }

    public boolean equals(int x, int y) {
	return (this.x == x && this.y == y);
    }

    public String toString() {
	return String.format("%d%d", x, y);
    }
}
