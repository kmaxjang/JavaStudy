package com.janggi;


import com.janggi.game.Msg;
import com.janggi.game.Point;

public class MainClass {

	public static void main(String[] args) {
		Msg.print("Java Study");
		Point p1 = new Point(1, 1);
		Point p2 = new Point(1, 1);
		Point p3 = new Point(3, 3);
		Msg.print("comper " + p2.getPoint().move(p1).comper(p3));
		p2.move(p1);
		p1.set(p2);
		Msg.print(p1.toString());

//=======================================		
		Msg.print("종료");
	}
}
