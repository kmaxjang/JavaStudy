package com.bighits.market;

import com.bighits.market.Wallet.Money;

public class Human extends People implements Employee{

	protected String name; // 이름
	private int live = 5; // 굼주림

	private int money = 0; // 재산
	private int foods = 0; // 음식
	private int hungry = 3; // 식량소비량
	private boolean job = false; // 직업유무

	public Human(String name) {
		this.name = name;
	}

	@Override
	public void setPay(Money money) {
				
	}

	@Override
	public void setFire(Money money) {
		
		job = false;
	}

	@Override
	public boolean getRetirement() {		
		return job;
	}

	@Override
	public Human getEmployeeInfo() {		
		return this;
	}

	@Override
	public void repeat(int year, int day) {
		
		System.out.println(name + " Age" + getAge() + " Life" + life + " Day" + day+"  "+population());		
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Food isHungry(int food) {
		
		return null;
	}
}
