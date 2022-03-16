package com.bighits.market;

import com.bighits.market.Wallet.Money;

public interface Client {	
	public String id();
	public String password();
	public void get(Bank bank);
	public int isMoney();
	public Client getMoney(Money money);
	public Client setMoney(Money money);
}
