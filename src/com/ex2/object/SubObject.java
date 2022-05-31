package com.ex2.object;

import java.util.Random;

import com.ex2.tool.Group;
import com.ex2.tool.Point;

public final class SubObject extends TopObject {

	private Random seed = new Random();
	private Point point = new Point(seed.nextInt(19), seed.nextInt(24));
	private static Group[] list = Group.values();

	public SubObject() {
		this(list[(new Random()).nextInt(3)]);
	}

	public SubObject(Group group) {
		super(group);
	}

	public Point getPoint() {
		switch (getGroup()) {
		case PLANT:
			break;
		case HERBIVORE:
			point.x += 1;
			if (point.x > 19) {
				point.x -= 19;
			}
			point.y += 1;
			if (point.y > 24) {
				point.y -= 24;
			}
			break;
		case CARNIVORE:
			point.x += seed.nextInt(5);
			if (point.x > 19) {
				point.x -= 19;
			}
			point.y += seed.nextInt(5);
			if (point.y > 24) {
				point.y -= 24;
			}
			break;
		}
		return point;
	}

}
