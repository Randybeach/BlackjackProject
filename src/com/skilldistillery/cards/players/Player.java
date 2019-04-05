package com.skilldistillery.cards.players;

public abstract class Player {
	Hand hand = new Hand();
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	public Hand getHand() {
		return hand;
	}
	public String getName() {
		return name;
	}
		
	
	
}
