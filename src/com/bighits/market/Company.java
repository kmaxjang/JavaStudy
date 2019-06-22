package com.bighits.market;

import com.bighits.market.Wallet.Money;

public interface Company {

	public boolean addEmploy(Employee job); // 고용

	public int getPersonnel(); // 총인원

	public boolean isWant_ad(); // 구인

	public boolean isClose();

	public int isCost(); // 가격

	public Food getBuy(Money money); // 구매
}
