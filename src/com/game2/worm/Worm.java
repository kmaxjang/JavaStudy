package com.game2.worm;

import java.util.Iterator;
import java.util.LinkedList;

public class Worm implements Schedule {

	private LinkedList<Point> worm = new LinkedList<>();

	private Way way;
	private int grow_length = worm.size();
	private int score = 0;
	private boolean death = true;

	public boolean isWork() {
		return death;
	}

	public void runWork() {
		// 전진해드 좌표
		worm.addFirst(way.move(worm.get(0)));
		if (worm.size() >= grow_length) {
			// 성장 이하일때 꼬리삭제
			worm.removeLast();
		}
	}
	// 지렁이 생성자
	public Worm(Way way, Point start_point) {
		this.way = way;
		Way bak = way.wayBack();
		worm.add(start_point.get());
		worm.add(bak.move(worm.get(0)));
		worm.add(bak.move(worm.get(1)));
		
		for (Point p : worm) {
			System.out.print(p);
		}
		System.out.println("");
	}
	// 전체좌표
	public Iterator<Point> getWorm() {
		return worm.iterator();
	}
	// 해드좌표
	public Point getWormHead() {
		return worm.getFirst();
	}
	// 점수
	public int getScore() {
		return score;
	}
	// 성장
	public void grow() {
		score++;
		grow_length++;
	}
	// 죽음
	public void death() {
		death = false;
	}
} // end