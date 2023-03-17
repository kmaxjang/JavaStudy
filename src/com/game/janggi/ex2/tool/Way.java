package com.game.janggi.ex2.tool;
/*
 * 방향 이동
 */
public enum Way {

	UP(0, -1), LEFTUP(1, -1), LEFT(1, 0), LEFTDOWN(1, 1), DOWN(0, 1), RIGHTDOWN(-1, 1), RIGHT(-1, 0), RIGHTUP(-1, -1);

	private static Point point = new Point();

	private final int mx;
	private final int my;

	private Way(int x, int y) {
		this.mx = x;
		this.my = y;
	}

	public static void set(Point setpoint) {
		point.set(setpoint);
	}

	public static Point get() {
		return point.get();
	}

	public Way move() {
		point.move(mx, my);
		return this;
	}
	
	public Way move(Way... ways ) {
		for(Way way: ways) {
			way.move();
		}
		return this;
	}

	public String toString() {
		return point.toString();
	}
}
