package com.ex2;

import com.ex2.object.SubObject;
import com.ex2.tool.Land;

public final class MainClass {

	public static void main(String[] args) {

		Land land = new Land();
		land.screen();
		land.addObject(new SubObject());
		land.addObject(new SubObject());
		land.addObject(new SubObject());
		land.addObject(new SubObject());
		land.addObject(new SubObject());
		land.addObject(new SubObject());
		land.screen();
		try {
			Thread.sleep(10000);
		} catch (Exception e) {

		}
	}
}
