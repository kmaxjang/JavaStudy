package com.sample.rotation;

import com.sample.rotation.Rotation.Index;

public class MainClass {

	private Rotation rt;
	private String[] menu = { "1 NewStart", "2 Load", "3 Option", "4 Exit"};
	private boolean rotaion = true;
	private int count = 0;

	public MainClass() {
		rt = new Rotation<String>() {

			private int nowcount = count;

			private int count(Index index) {
				switch (index) {
				case previous:
					nowcount -= 1;
					if (nowcount < 0) {
						nowcount = rotaion ? getMaxIndex() : 0;
					}
					break;
				case next:
					nowcount += 1;
					if (nowcount >= menu.length) {
						nowcount = !rotaion ? getMaxIndex() : 0;
					}
					break;
				case now:
				}
				return nowcount;
			}

			@Override
			public boolean isRotation() {
				return rotaion;
			}

			@Override
			public String getItem(Index index) {
				return menu[count(index)];
			}

			@Override
			public String getItem(int index) {
				if (index != 0) {
					index = Math.abs(index);
					index %= (getMaxIndex() + 1);
				}
				return menu[index];
			}

			@Override
			public int getNowIndex() {
				return nowcount;
			}

			@Override
			public int getMaxIndex() {
				return menu.length - 1;
			}
		};
	}

	public void rotation(boolean rotat) {
		rotaion = rotat;
	}

	public Rotation getRotation() {
		return rt;
	}

	public static void main(String[] args) {

		MainClass mc = new MainClass();
		Rotation rt = mc.getRotation();
		System.out.println("=========");
		System.out.println(rt.getItem(Index.now));
		for (int a = 0; a < 10; a++) {
			System.out.println(rt.getItem(Index.next));
		}
		System.out.println("=========");
		System.out.println(rt.getItem(Index.now));
		for (int a = 0; a < 10; a++) {
			System.out.println(rt.getItem(Index.previous));
		}
		System.out.println("=========");
		for (int a = -10; a < 10; a++) {
			System.out.println(rt.getItem(a));
		}
	}
}
