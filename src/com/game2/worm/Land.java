package com.game.worm;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

// 백그라운드
public class Land implements Schedule {

	// enum 마커정의
	public enum Mark {
		WALL("W"), SPACE(" "), WORM_HEAD("H"), WORM_BADY("B"), WORM_TAIL(
				"T"), FRUTE("F");

		private String value; // 마커 기본값

		private Mark(String value) {
			this.value = value;
		}

		public String getVelue() {
			return value;
		}
	} // mark end

	// 맵 크기
	private Map<Mark> map = new Map<Mark>(44, 26, Mark.SPACE);

	// 게임 루프관리
	private Scheduler sch = new Scheduler();

	// 생성자
	public Land() {
		sch.add(this);
	}

	// 게임시작
	public void start() {
		setLand();
		setFood();
		sch.run();
	}

	private boolean gameover = false;
	
	public boolean isWork() {
		return !gameover;
	}

	public void runWork() {
		setLand(); // 배경
		map.setMark(food_point.x, food_point.y, Mark.FRUTE);
		setWorms();
		print(map.getMap()); // 최종 결과물
		if(worms.size() == 0)
				gameover = true;
		
	}

	// 랜덤 씨앗
	private Random seed = new Random();
	private Point food_point = new Point();

	// 랜덤 프드 뿌리기
	public void setFood() {
		int count =0;
		while (count < map.SCREEN_SIZE_X*map.SCREEN_SIZE_Y) {
			food_point.x = seed.nextInt(map.SCREEN_SIZE_X);
			food_point.y = seed.nextInt(map.SCREEN_SIZE_Y);
			if (map.getMark(food_point.x, food_point.y).equals(Mark.SPACE)) {				
				return;
			}
			count++;
		}
	}

	private StringBuffer sb = new StringBuffer(
			map.SCREEN_SIZE_X * map.SCREEN_SIZE_Y);
	// private Point tmp_point = new Point();
	// 화면에 그리기
	public void print(Iterator<Mark> e) {
		sb.delete(0, sb.length());
		for (int y = 0; y < map.SCREEN_SIZE_Y; y++) {
			for (int x = 0; x < map.SCREEN_SIZE_X; x++) {
				sb.append(e.next().getVelue());
			}
			sb.append("\n");
		}
		for (Worm worm : worms) {
			System.out.println("Worm Score" + worm.getScore());
		}
		System.out.println(sb);
	}

	private List<Worm> worms = new ArrayList<>();
	private Way[] way = Way.values();
	// 웜 등록
	public boolean addWorm() {
		Point np = new Point();
		np.x = seed.nextInt(map.SCREEN_SIZE_X/2)+10;
		np.y = seed.nextInt(map.SCREEN_SIZE_Y/2)+10;		
		Worm worm = new Worm(way[seed.nextInt(way.length-1)],np);
		if (worms.add(worm)) {
			sch.add(worm);			
			return true;
		}
		return false;
	}
	
	// 웜들 맵에 기록
	public void setWorms() {
		for (Iterator<Worm> wormlist = worms.iterator() ; wormlist.hasNext() ; ) {
			Worm worm = wormlist.next();
			Iterator<Point> w = worm.getWorm();
			Point tp = w.next();
			switch (map.getMark(tp.x, tp.y)) {
				case WALL : // game over
				case WORM_HEAD :
				case WORM_BADY :
				case WORM_TAIL :
					worm.death(); //
					wormlist.remove();
					break;
				case FRUTE :
					worm.grow();
					setFood();
				case SPACE :
					map.setMark(tp.x, tp.y, Mark.WORM_HEAD);
					while (true) {
						tp = w.next();
						if (w.hasNext()) {
							map.setMark(tp.x, tp.y, Mark.WORM_BADY);
						} else {
							map.setMark(tp.x, tp.y, Mark.WORM_TAIL);
							break;
						}
					} // while end
			} // switch end
		} // for end
	}

	// 배경 기록
	private void setLand() {
		for (int x = 0; x < map.SCREEN_SIZE_X; x++) {
			for (int y = 0; y < map.SCREEN_SIZE_Y; y++) {
				if (x == 0 || x == map.SCREEN_SIZE_X - 1 || y == 0
						|| y == map.SCREEN_SIZE_Y - 1) {
					map.setMark(x, y, Mark.WALL);
				} else {
					map.setMark(x, y, Mark.SPACE);
				}
			}
		}
	}
}
