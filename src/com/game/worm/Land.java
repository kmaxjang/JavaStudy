package com.game.worm;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

// 백그라운드
public class Land implements Schedule {

	// 마커정의
	public enum Mark {
		WALL("W"),
		SPACE(" "),
		WORM_HEAD("H"),
		WORM_BADY("B"),
		WORM_TAIL("T"),
		FRUTE("F");

		private String value;

		private Mark(String value) {
			this.value = value;
		}

		public String getVelue() {
			return value;
		}
	}
	// 랜드크기
	private int size_x = 30;
	private int size_y = 25;
	// 랜드맵
	private Mark[][] mark_map = new Mark[size_x][size_y];
	
	private Scheduler sch = new Scheduler();
	
	// 생성자
	public Land() {
		setLand();
		setfood();
		sch.add(this);
	}

	public boolean isWork() {
		return true;
	}

	public void runWork() {
		setWorms();
		print();
	}

	// 랜덤 씨앗
	private Random seed = new Random();
	private Point food_point = new Point();

	// 랜덤 프드 뿌리기
	public void setfood() {
		while (true) {
			food_point.x = seed.nextInt(size_x);
			food_point.y = seed.nextInt(size_y);
			if (getMark(food_point).equals(Mark.SPACE)) {
				setMark(food_point, Mark.FRUTE);				
				break;
			}
		}
	}
	
	// 배경설정
	public void setMark(Point p, Mark mark) {
		mark_map[p.x][p.y] = mark;
	}
	
	// 배경가져오기
	public Mark getMark(Point p) {
		return mark_map[p.x][p.y];
	}
	
	// 화면에 그리기
	private StringBuffer sb = new StringBuffer(size_x * size_y);
	private Point tmp_point = new Point();
	public void print() {
		sb.delete(0, sb.length()); // 초기화
		for (int y = 0; y < size_y; y++) {
			for (int x = 0; x < size_x; x++) {
				tmp_point.set(x, y);
				sb.append(getMark(tmp_point).getVelue());
			}
			sb.append("\n");
		}
		for(Worm worm : worms) {
			System.out.println("Worm score : " + worm.getScore());
		}		
		System.out.println(sb);
	}

	private List<Worm> worms = new ArrayList<>();

	public boolean addWorm(Worm worm) {
		worms.add(worm);
		sch.add(worm);
		return true;
	}
//
	public void setWorms() {
		for (Worm worm : worms) {
			List<Point> w = worm.getWorm();
			int length = w.size();
			setMark(w.get(0), Mark.WORM_HEAD);
			for(int c =1; c < length-2; c++) {
				setMark(w.get(length - 1), Mark.WORM_BADY);
			}
			setMark(w.get(length - 1), Mark.WORM_TAIL);
		}
	}
	
	// 배경초기화
	private void setLand() {
		for (int x = 0; x < size_x; x++) {
			for (int y = 0; y < size_y; y++) {
				tmp_point.set(x, y);
				if (x == 0 || x == size_x - 1 || y == 0 || y == size_y - 1) {
					setMark(tmp_point, Mark.WALL);
				} else {
					setMark(tmp_point, Mark.SPACE);
				}
			}
		}
	}
	
	public void start() {
		sch.run();
	}
}
