package com.bighits.market;

import com.bighits.market.Wallet.Money;

public interface Employee {
	
	public void setPay(Money money);
	public void setFire(Money money);
	public boolean getRetirement();
	public Human getEmployeeInfo();

}
