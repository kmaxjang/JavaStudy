package com.game.worm;

public class Worm implements Schedule {

	private int tail = 0;
	private int head = 0;

	private Point[] body;

	private Way way = Way.DOWN;
	private boolean grow = false;

public boolean isWork(){
  return true;
}

public void runWork(){
  drow();
}

	public Worm(int worm_max_size, Way move) {
		body = new Point[worm_max_size];
	}

	private void setGrow(int food) {
	}

	private int check(int length) {
		length++;
		return (length >= body.length) ? 0 : length;
	}

	public void drow() {
		int p = head;
		while (true) {
			p--;
			if (p == tail) {
				break;
			} else if (p <= 0) {
				p = body.length - 1;
			}
		}
	}

}
