package com.game.janggi.ex.ex1;

import com.game.janggi.ex.util.Move;
import com.game.janggi.ex.util.PieceBuild;
import com.game.janggi.ex.util.Point;

public class MainClass {

	public static void msg(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		msg("Janggi king");
		Point point = new Point();
		point.set("09");
		msg(point.toString());

		PieceBuild pb = new PieceBuild();
		pb.set("1732127");
		msg("1732127");
		msg(pb.getGroup().name());
		msg(pb.getName().name());
		msg(pb.getPosition().toString());
		msg(pb.getOldPosition().toString());
		msg(pb.getKillName().name());

		Move[] way = Move.values();
		msg(way[0].point.toString());
		for (Move m : way) {
			msg(m.name());
		}

	}
}
