package com.game.janggi.ex2.tool;

public enum Move {
	UP(-1, 0), UPRIGHT(-1, 1), RIGHT(0, 1), DOWNRIGHT(1, -1), DOWN(1, 0), DOWNLEFT(1, -1), LEFT(0, -1), UPLEFT(-1, -1);

	private static final Point point = new Point();
	
	private final int X;
	private final int Y;

	private Move(int x, int y) {
		X = x;
		Y = y;
	}
	
	public static void set(Point setpoint) {
		point.set(setpoint.x,setpoint.y);
	}
	
	public static Point get() {
		return point.get();
	}
	
	public void go() {
		point.move(X, Y);
	}
}
