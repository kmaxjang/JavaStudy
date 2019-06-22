package com.bighits.market;

import java.util.HashMap;

public final class Bank {

	private final static Bank bank = new Bank();
	private static HashMap<String, String> client_list = new HashMap<String, String>();
	private static HashMap<String, Integer> client_money = new HashMap<String, Integer>();

	private Bank() {

	}

	public static boolean registry(Client client) {
		if (!client_list.containsKey(client.id())) {
			client_list.put(client.id(), client.password());
			client_money.put(client.id(), 1000);
			client.get(bank);
			return true;
		}
		return false;
	}

	public boolean login(String id, String password) {
		return false;
	}

	public int isMoney() {
		return 0;
	}

	public Wallet get() {
		return null;
	}

}
