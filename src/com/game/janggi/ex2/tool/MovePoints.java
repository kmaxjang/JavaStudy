package com.game.janggi.ex2.tool;

import java.util.Iterator;

/*
 * 좌표모음 저장
 */

public class MovePoints {

	private Point[] list;
	private int limet = -1;

	public MovePoints(int lenght) {
		list = new Point[lenght];
	}

	public MovePoints(MovePoints mps) {
		list = new Point[mps.getLength()];
		Iterator<Point> iter = mps.getIterate();
		while (iter.hasNext()) {
			add(iter.next());
		}
	}

	public void add(Point p) {
		limet++;
		list[limet] = p;
	}

	public int comper(Point p) {
		for (int i = 0; i < limet; i++) {
			if (list[i].equals(p)) {
				return i;
			}
		}
		return -1;
	}

	public void reset() {
		limet = -1;
	}

	public int getLimet() {
		return limet;
	}

	public int getLength() {
		return list.length;
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
