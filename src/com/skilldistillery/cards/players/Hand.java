package com.skilldistillery.cards.players;

import java.util.ArrayList;
import java.util.List;
import com.skilldistillery.cards.common.Card;

public class Hand {
	private int value;
	private List<Card> cards = new ArrayList<>();
	public Hand() {
	}
	public int getHandValue() {
		return value;
	}
	public void addCard(Card card) {
		cards.add(card);
		value += card.getValue();
	}
	public void clearHand() {
		cards.removeAll(cards);
		value = 0;
	}
	public List<Card> getCards(){
		return cards;
	}
	@Override
	public String toString() {
		return "Hand [value=" + value + ", cards=" + cards + "]";
	}
	
}
