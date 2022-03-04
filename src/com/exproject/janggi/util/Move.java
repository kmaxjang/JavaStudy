package com.exproject.janggi.util;

// 이동좌표 계산
public enum Move {
	UP(0, -1), RIGHTUP(1, -1), RIGHT(1, 0), RIGHTDOWN(1, 1), DOWN(0, 1), LEFTDOWN(-1, 1), LEFT(-1, 0), LEFTUP(-1, -1);

	private int move_x;
	private int move_y;

	public static final int min_x = 0;
	public static final int min_y = 0;

	public static final int max_x = 9;
	public static final int max_y = 10;

	public static final Point point = new Point(); // 좌표기역

	private Move(int x, int y) {
		move_x = x;
		move_y = y;
	}

	// 이동
	public Move move() {
		point.x += move_x;
		point.y += move_y;
		return this;
	}

	// 이동반복
	public Move move(int move) {
		if (move < 0) {
			for (int a = 0; a > move; a--) {
				switch (this) {
				case UP:
					DOWN.move();
					break;
				case RIGHTUP:
					LEFTDOWN.move();
					break;
				case RIGHT:
					LEFT.move();
					break;
				case RIGHTDOWN:
					LEFTUP.move();
					break;
				case DOWN:
					UP.move();
					break;
				case LEFTDOWN:
					RIGHTUP.move();
					break;
				case LEFT:
					RIGHT.move();
					break;
				case LEFTUP:
					RIGHTDOWN.move();
					break;
				}
			}
		} else {
			for (int a = 0; a < move; a++) {
				move();
			}
		}
		return this;
	}

	// 범위판정
	public boolean scope() {
		switch (this) {
		case UP:
			return (point.y >= min_y);
		case RIGHTUP:
			return (Move.RIGHT.scope() && Move.UP.scope());
		case RIGHT:
			return (point.x < max_x);
		case RIGHTDOWN:
			return (Move.RIGHT.scope() && Move.DOWN.scope());
		case DOWN:
			return (point.y < max_y);
		case LEFTDOWN:
			return (Move.LEFT.scope() && Move.DOWN.scope());
		case LEFT:
			return (point.x >= min_y);
		case LEFTUP:
			return (Move.LEFT.scope() && Move.UP.scope());
		}
		return false;
	}
}
