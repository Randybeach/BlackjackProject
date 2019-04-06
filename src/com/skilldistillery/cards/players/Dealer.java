package com.skilldistillery.cards.players;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Dealer extends Player {
	Deck deck = new Deck();
	public Dealer(String name) {
		super("Dealer");
		deck.shuffleDeck();
	}
	
	public Card dealCard() {
		return deck.dealCard();
	}
	public void shuffleDeck() {
		deck.shuffleDeck();
	}
	public int checkDeckSize() {
		return deck.checkDeckSize();
	}
	public void getNewDeck() {
		deck = new Deck();
	}
	public Card getPartialHand() {
		return hand.getCards().get(0);
	}
	public Deck showDeck() {
		return deck;
	}
}
