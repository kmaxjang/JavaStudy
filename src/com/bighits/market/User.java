package com.bighits.market;

public class User implements LifeTime {

	private int foods = 0;
	private int money = 0;
	private int fayday = 0;
	private int fay = 0;
	private int onedayfood = 0;
	private int life = 5;

	public User(int fay) {
		this.fay = fay;
		this.fayday = God.god.getDay();
		God.god.add(this);
		lifestyle();
	}

	public void getAlarm(int year, int day) {
		if (fayday == day) {
			money += fay;
			lifestyle();
		}
		foods -= onedayfood;
		if (foods < onedayfood) {

		}
		// System.out.println("User"+money+"Food"+foods);
	}

	private void lifestyle() {
		if (money > 1000) {
			onedayfood = 9;
		} else if (money < 200) {
			onedayfood = 3;
		} else {
			onedayfood = 6;
		}
	}

	@Override
	public boolean death() {
		
		return false;
	}
}
