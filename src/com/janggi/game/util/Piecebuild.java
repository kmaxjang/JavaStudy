package com.janggi.game.util;

import com.janggi.game.Point;

public interface Piecebuild {
	
	// 방향 기본
	int LIFT = -1, UP = -1;
	int RIGHT = 1, DOWN = 1;
	
	// 방향 (12시 0)
	Point leftup = new Point(LIFT, UP), up = new Point(0, UP), rightup = new Point(RIGHT, UP),
	        left = new Point(LIFT, 0), right = new Point(RIGHT, 0), leftdown = new Point(LIFT, DOWN),
	        down = new Point(0, DOWN), rightdown = new Point(RIGHT, DOWN);
	
	// 방향모음
	Point[] way = { up, right, down, left };
	Point[] way_diagonal = { rightup, rightdown, leftdown, leftup };
	Point[] way_all = { up, rightup, right, rightdown, down, leftdown, left, leftup };
	
	// 궁좌표 (초 0~ 한 4~)
	Point[] palace_point = { new Point(4, 0), new Point(5, 1), new Point(4, 2), new Point(3, 1), new Point(4, 6),
	        new Point(5, 7), new Point(4, 8), new Point(3, 7) };
	Point[] palace_edge_point = { new Point(5, 0), new Point(5, 2), new Point(3, 2), new Point(3, 0), new Point(5, 6),
	        new Point(5, 8), new Point(3, 8), new Point(3, 6) };	
	Point[] palace_center_point = { new Point(4, 1), new Point(4, 7) };
	
}