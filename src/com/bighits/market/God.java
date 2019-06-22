package com.bighits.market;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class God implements Runnable {

	public static final God god = new God();
	
	private int day = 0;
	private int year = 0;
	private Set<LifeTime> list = new HashSet<LifeTime>();

	private God() {
		new Thread(this).start();
		System.out.println("day run");
	}

	public void run() {
		while (true) {
			year += 1;// (day % 30 == 0) ? 1 : 0;
			day = (day % 30) + 1;

			Iterator<LifeTime> human = list.iterator();
			while (human.hasNext()) {
				LifeTime life = human.next();
				if (!life.death()) {
					life.getAlarm(year, day);
				} else {
					human.remove();
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("<<<<<<<<<<<<<<<<<<<Year" + year + " Day" + day);
		}
	}

	public int getDay() {
		return day;
	}

	public int getYear() {
		return year;
	}

	public void add(LifeTime t) {
		list.add(t);
	}
}