package com.game.janggi.ex5;

public class Command {

	private boolean updata = false;
	private int[] data = null;

	public Command() {

	}

	public boolean isUpdata() {
		return updata;
	}

	public void move(int point, int move) {
		data = new int[2];
		data[0] = point;
		data[1] = move;
		updata = true;
	}

	public int[] getData() {
		return data;
	}

}
