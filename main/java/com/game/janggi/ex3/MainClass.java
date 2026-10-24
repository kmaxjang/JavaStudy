package com.game.janggi.ex3;


import com.game.janggi.ex3.game.Msg;
import com.game.janggi.ex3.game.Point;

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
