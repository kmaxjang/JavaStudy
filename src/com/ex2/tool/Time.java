package com.ex2.tool;

import java.util.ArrayList;
import java.util.Iterator;

public class Time {

	private static Time time = null;
	private Thread thread;
	private boolean run = true;
	private boolean addbool = false;
	private long sleeptime = 0;

	private ArrayList<Influence> addlist = new ArrayList<>();
	private ArrayList<Influence> list = new ArrayList<>();

	private Time() {
		thread = new Thread(new Runnable() {
			public void run() {
				int loopcount = 0;
				System.out.println("루프시작");
				while (true) {
					start();
					if (loopcount > 60 && list.size() == 0) {
						break;
					} else {
						loopcount++;
					}
					try {
						Thread.sleep(100);
					} catch (Exception e) {

					}
				}
				run = false;
				System.out.println("루프종료");
			}
		});
		thread.start();
	}

	public static Time getInstense() {
		if (time == null) {
			time = new Time();
		}
		return time;
	}

	public boolean isRun() {
		return run;
	}

	private void start() {
		while (addbool || list.size() != 0) {
			sleeptime = System.currentTimeMillis();
			Iterator<? extends Influence> it = list.iterator();
			while (it.hasNext()) {
				TimeLoop deliver = it.next();
				if (deliver.death()) {
					it.remove();
				} else {
					deliver.loop();
				}
			}
			if (addbool) {
				list.addAll(addlist);
				addlist.clear();
				addbool = false;
			}
			System.out.println("루프");
			sleeptime = System.currentTimeMillis() - sleeptime;
			try {
				Thread.sleep(500 - sleeptime);
			} catch (Exception e) {

			}
		}
	}

	public boolean add(Influence object) {
		addbool = list.add(object);
		System.out.println("add");
		return addbool;
	}

	public Iterator<Influence> iterator() {		
		return list.iterator();
	}
}