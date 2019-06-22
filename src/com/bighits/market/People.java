package com.bighits.market;

public abstract class People implements LifeTime {
	
	private static int population =0; //인구
	private int birthday = 0; //태어난날
	protected final int life; // 기대수명

	private int hungry = 5; // 굼주림

	public People() {
		population++;
		life = ((int) (Math.random() * 20)) + 40;
		birthday = God.god.getYear();
		God.god.add(this);
	}
	
	@Override
	public final void getAlarm(int year, int day) {

		repeat(year, day);		
	}
	
	@Override
	public final boolean death() {
		if(hungry == 0 || getAge() >= life) {
			population--;
			return true;
		}		
		return false;
	}

	public final int population() {
		return population;
	}
	
	public final int getAge() {
		return God.god.getYear() - birthday;
	}
	
	public abstract void repeat(int year, int day);
	public abstract Food isHungry(int food);
	public abstract String getName();
	
}
