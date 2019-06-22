package com.bighits.market;

public final class Wallet {

	private String id;
	private String password;

	private Client client = new Client() {
		
		private boolean login = false;
		private Bank bank = null;

		public String id() {
			return id;
		}

		public String password() {
			return password;
		}

		public boolean login() {
			return login;
		}

		public void get(Bank b) {
			bank = b;
		}

		public int isMoney() {
			return bank.isMoney();
		}

		public Client getMoney(Money money) {
			

			return this;
		}

		public Client setMoney(Money money) {

			return this;
		}
	};

	private int money = 0;

	public Wallet(String id, String password) {
		this.id = id;
		this.password = password;
		Bank.registry(client);
	}

	public int isMoney() {
		return money;
	}

	public Money getMoney(int money) {
		if (this.money == 0) {
			return null;
		} else if (this.money <= money) {
			money = this.money;
			this.money = 0;
		} else {
			this.money -= money;
		}
		return new Money(money);
	}

	public boolean setMoney(Money money) {
		if (money == null) {
			return false;
		}
		this.money += money.get();
		return true;
	}

	public final class Money {

		private int money;
		private boolean flag = true;

		public Money(int money) {
			this.money = money;
		}

		public int get() {
			if (flag) {
				flag = false;
				return money;
			}
			return 0;
		}

		public int isMoney() {
			return (flag) ? money : 0;
		}
	}
}
