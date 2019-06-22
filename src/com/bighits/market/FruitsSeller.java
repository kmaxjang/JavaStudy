package com.bighits.market;

public class FruitsSeller implements LifeTime {

	private int fruits = 0;
	private int cost = 0;
	private int money = 0;
	private int bay = 0;
	private int harvest = 0;

	public FruitsSeller(int money) {
		this.money = money;
		harvest = God.god.getDay();
		God.god.add(this);
	}

	public void getAlarm(int year, int day) {
		if (harvest == day) {
			getHarvest();
		}
		fruits -= 10;
		System.out.println("Seller" + money + "fruits" + fruits + " cost" + cost);
	}

	public int cost() {
		return cost;
	}

	private void getHarvest() {
// 풍작 20
// 평작 70
// 흉작 10
		int j = (int) (Math.random() * 10);
		if (j > 7) {
			fruits += 1000;
			cost = 2;
		} else if (j < 2) {
			fruits += 100;
			cost = 6 + (1000 / (fruits + 1));
		} else {
			fruits += 500;
			cost = 6;
		}
		money -= 1000;

	}

	@Override
	public boolean death() {
		
		return true;
	}
}
