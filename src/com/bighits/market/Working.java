package com.bighits.market;

import java.util.HashSet;
import java.util.Set;

import com.bighits.market.Wallet.Money;

public class Working implements Company, LifeTime {

	private String working_name;
	private int money;
	private int foods = 0;
	private int cost;
	private int pay;
	private Set employ = new HashSet();
	private int headcount;

	public Working(String workingname, Human master) {

	}

	private void produce() {

	}

	@Override
	public void getAlarm(int year, int day) {
		
	}

	@Override
	public boolean death() {
		
		return false;
	}

	@Override
	public int getPersonnel() {
		
		return 0;
	}

	@Override
	public boolean isWant_ad() {
		
		return false;
	}

	@Override
	public int isCost() {
		
		return 0;
	}

	@Override
	public Food getBuy(Money money) {
		
		return null;
	}

	@Override
	public boolean isClose() {
		
		return false;
	}

	@Override
	public boolean addEmploy(Employee job) {
		
		return false;
	}
}
