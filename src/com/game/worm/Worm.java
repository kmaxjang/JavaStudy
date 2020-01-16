package com.game.worm;

import java.util.ArrayList;
import java.util.List;

public class Worm implements Schedule {

	private List<Point> worm = new ArrayList<>();	
	private int worm_size;
	private int score =0;
	private Way way;

	public boolean isWork() {
		return true;
	}

	public void runWork() {
		way.move(way, worm.get(0));
	}
	
	// 생성자
	public Worm(Way way, Point start_point) {
		this.way = way;
		worm.add(start_point); // 머리
		worm.add(way.wayBack().move(start_point)); // 꼬리
		worm_size = worm.size();		
	}

	public List<Point> getWorm() {
		return worm;
	}

	public boolean grow() {
		worm_size++;
		return false;
	}
	
	public int getScore() {
		return score;
	}
}
