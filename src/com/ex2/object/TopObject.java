package com.ex2.object;

import com.ex2.tool.Group;
import com.ex2.tool.Influence;
import com.ex2.tool.Point;

public abstract class TopObject implements Influence {

	private int life = 100;
	private int speed = 0;
	private int age = 1;
	private int maxage = 0;

	private Group group;

	public TopObject(Group group) {
		this.group = group;
		setObject();
	}

	private void setObject() {
		switch (group) {
		case PLANT:
			life = 500;
			speed = 0;
			maxage = 100;
			break;
		case HERBIVORE:
			life = 100;
			speed = 10;
			maxage = 50;
			break;
		case CARNIVORE:
			life = 50;
			speed = 8;
			maxage = 30;
			break;
		}
	}

	public final void loop() {
		System.out.println("Group :" + group + " age" + age);
		age++;
	}

	public final boolean death() {
		return (life <= 0 || age > maxage);
	}

	public Group getGroup() {
		return group;
	}

	public String info() {
		return group.toString();
	}

	public abstract Point getPoint();
}
