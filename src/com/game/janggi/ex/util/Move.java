package com.game.janggi.ex.util;

// 이동좌표 계산
public enum Move {
	LEFTUP(-1, -1), UP(0, -1), RIGHTUP(1, -1), LEFT(-1, 0), RIGHT(1, 0), LEFTDOWN(-1, 1), DOWN(0, 1), RIGHTDOWN(1, 1);

	private int movex;
	private int movey;

	public static final int min_x = 0;
	public static final int min_y = 0;

	public static final int max_x = 9;
	public static final int max_y = 10;

	public static final Point point = new Point(0, 0); // 좌표기역

	private Move(int x, int y) {
		movex = x;
		movey = y;
	}

	public void move() {
		point.setX(point.getX() + movex);
		point.setY(point.getY() + movey);
	}

	public void move(int move) {
		if (move <= 1) {
			move();
		} else {
			for (int a = 0; a < move; a++) {
				move();
			}
		}
	}

	public boolean scope() {
		switch (this) {
		case LEFTUP:
			return (Move.LEFT.scope() && Move.UP.scope());
		case UP:
			return (point.getY() >= min_y);
		case RIGHTUP:
			return (Move.RIGHT.scope() && Move.UP.scope());
		case LEFT:
			return (point.getX() >= min_y);
		case RIGHT:
			return (point.getX() < max_x);
		case LEFTDOWN:
			return (Move.LEFT.scope() && Move.DOWN.scope());
		case DOWN:
			return (point.getY() < max_y);
		case RIGHTDOWN:
			return (Move.RIGHT.scope() && Move.DOWN.scope());
		}
		return false;
	}
}
