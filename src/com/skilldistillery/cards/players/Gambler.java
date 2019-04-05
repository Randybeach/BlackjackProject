package com.skilldistillery.cards.players;

public class Gambler extends Player {
	private int money = 500;
	
	public Gambler(String name) {
		super(name);
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	

	
}
