package com.game2.worm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Map<E> {

	public final int SCREEN_SIZE_X;
	public final int SCREEN_SIZE_Y;

	private List<E> map = new ArrayList<>();

	public Map(int size_x, int size_y, E setting) {
		SCREEN_SIZE_X = size_x;
		SCREEN_SIZE_Y = size_y;
		//초기화
		for(int i = 0; i <= size_x*size_y; i++) {
			map.add(setting);
		}
	}

	public void setMark(int x, int y, E mark) {
		map.set(x+(y*SCREEN_SIZE_X), mark);
	}

	public E getMark(int x, int y) {
		E e = map.get(x+(y*SCREEN_SIZE_X));
		return e;
	}
	
	public Iterator<E> getMap() {
		return map.iterator();
	}

}
