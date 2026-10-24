package com.game.janggi.ex2.tool;

/*
 *  좌표
 */

public class Point {

    public int x = 0;
    public int y = 0;

    public Point(int x, int y) {
	this.x = x;
	this.y = y;
    }

    public Point(Point point) {
	this(point.x, point.y);
    }

    public Point() {
	this(0, 0);
    }

    public Point set(int x, int y) {
	this.x = x;
	this.y = y;
	return this;
    }

    public Point set(Point point) {
	set(point.x, point.y);
	return this;
    }

    public Point get() {
	return new Point(this);
    }

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    public Point move(int x, int y) {
	this.x += x;
	this.y += y;
	return this;
    }

    public Point move(Point p) {
	move(p.x, p.y);
	return this;
    }

    public boolean equals(Point point) {
	return (x == point.x && y == point.y);
    }

    public String toString() {
	return String.format("%d%d", x, y);
    }
}