package com.game.janggi.ex5;

import java.util.HashMap;
import java.util.Iterator;

import com.game.janggi.ex2.tool.Point;

public class Screen {

	private StringBuffer data = new StringBuffer(200);
	private String[] marker = { "🔳", "🐶", "🐯", "🐵", "🐴", "🐮", "🐰", "🐭", "🐕", "🐅", "🐒", "🐎", "🐂", "🐇",
			"🐁", "🔅", "🚫", "🔆" };

	private HashMap<Integer, String> piecelayout = new HashMap<>(32);
	private HashMap<Integer, String> movelayout = new HashMap<>(21);
	private HashMap<Integer, String> stringlayout = new HashMap<>();

	private boolean updata = false;

	public Screen() {
	}

	public void background() {
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 9; x++) {
				data.append(marker[0]);
			}
			data.append(" \n");
		}
		// y 0~9
		// x 0~8
		// xy y*9+x
		// piece 1~14
		// han 1 ~ 1+=2
		// cho 2 ~ 2+=2
/*		
		insert(0, marker[2]);
		insert(1, marker[4]);
		insert(2, marker[5]);
		insert(3, marker[6]);
		insert(5, marker[6]);
		insert(6, marker[4]);
		insert(7, marker[5]);
		insert(8, marker[2]);
		insert(14, marker[1]);
		insert(21, marker[3]);
		insert(27, marker[3]);
		insert(30, marker[7]);
		insert(32, marker[7]);
		insert(34, marker[7]);
		insert(36, marker[7]);
		insert(38, marker[7]);

		for (int x = 0; x < marker.length; x++) {
			System.out.println(marker[x] + " size" + marker[x].length());
		}
		System.out.println("" + data + data.length());

		insert(20, marker[15]);
		insert(22, marker[15]);
		System.out.println("" + data + data.length());

		insert(1);
		insert(22, marker[7]);
		System.out.println("" + data + data.length());
//*/
	}

	public void asmble(Point point, int piece) {
		int code = point.y * 10 + point.x;
		int mark = ((piece < 20)?0:7)+ piece%10;
		insert(code, marker[mark]);		
		System.out.println("Point " + code +" Piece"+ mark);
		System.out.println("" + data + data.length());
	}

	public void insert(int index, String marker) {
		index *= 2;
		data.replace(index, index + 2, marker);
	}

	public void insert(int index) {
		index *= 2;
		data.replace(index, index + 2, marker[0]);
	}

	public void moveable(Iterator<Integer> point) {

	}

	public void updata() {
		data.delete(0, data.length());
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 9; x++) {
				data.append(piecelayout.getOrDefault(y * 10 + x, marker[0]));
			}
			data.append(" \n");
		}

		updata = true;
		draw();
	}

	private void draw() {
		System.out.println(data);
	}

	public void run() {
		while (true) {
			if (updata) {
				draw();
				updata = false;
			}
		}
	}
}
