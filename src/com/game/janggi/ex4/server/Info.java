/*
 *  �� = 1 true
 *  �� = 2 false
 *  
 *  �� �� �� �� �� �� ��
 *  7  6  5   4   3  2  1
 *  
 *  ��ǥ 0--->x
 *        |
 *        y
 * 
 */

package com.jjanggi2.server;

import java.awt.Point;

public final class Info {

	private boolean team;
	private int kinds;
	private Point point;

	public Info(int data) {
		team = (data / 1000 == 1) ? true : false;
		kinds = (data / 100 % 10);
		point = new Point(data / 10 % 10, data % 10);
	}

	public boolean getTeam() {
		return team;
	}

	public int getKinds() {
		return kinds;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point p) {
		point.setLocation(p);
	}

	public int getData() {
		return (team ? 1000 : 2000) + (kinds * 100) + (point.x * 10 + point.y);
	}
}
