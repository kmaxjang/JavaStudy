package com.bighits.market;

public class Food implements LifeTime{

	private int foods = 0;
	private final int expiry_date = 5;
	private int date = 0;
	
	public Food(int food) {
		God.god.add(this);
	}
	
	public int get(int food) {
		if(foods <= food) {			
			return foods;
		}
		foods -= food;
		return food;
	}
	
	public int isFood() {
		return foods;
	}

	public void add(Food food) {
		foods += food.get(food.isFood());		
	}

	@Override
	public void getAlarm(int year, int day) {
		if(expiry_date == date) {
			
			date =0;
		}else {
			date++;
		}
	}

	@Override
	public boolean death() {		
		return false;
	}
}
