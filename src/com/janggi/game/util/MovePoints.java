package com.janggi.game.util;

import java.util.Iterator;

import com.janggi.game.Point;

public class MovePoints {

	private Point[] list;
	private int limet = -1;

	public MovePoints(int lenght) {
		list = new Point[lenght];
	}

	public MovePoints(MovePoints mps) {
		list = new Point[mps.getLimet()];
		Iterator<Point> iter = mps.getIterate();
		while (iter.hasNext()) {
			add(iter.next());
		}
	}

	public void add(Point p) {
		limet++;
		list[limet] = p;
	}

	public boolean comper(Point p) {
		for (int i = 0; i < limet; i++) {
			if (list[i].comper(p)) {
				return true;
			}
		}
		return false;
	}

	public void reset() {
		limet = -1;
	}

	public int getLimet() {
		return limet;
	}

	public Iterator<Point> getIterate() {
		return new Iterator<Point>() {

			private int count = limet;
			private Point[] iter;
			{
				System.arraycopy(list, 0, iter, 0, limet);
			}

			@Override
			public boolean hasNext() {
				return (count < 0);
			}

			@Override
			public Point next() {
				Point tmp = iter[count];
				count--;
				return tmp;
			}

		};
	}
}
