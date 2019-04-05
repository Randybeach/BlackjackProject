package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	public List<Card> cards = new ArrayList<>();

	public Deck() {
		cards.add(new Card(Rank.TWO, Suit.SPADES));
		cards.add(new Card(Rank.THREE, Suit.SPADES));
		cards.add(new Card(Rank.FOUR, Suit.SPADES));
		cards.add(new Card(Rank.FIVE, Suit.SPADES));
		cards.add(new Card(Rank.SIX, Suit.SPADES));
		cards.add(new Card(Rank.SEVEN, Suit.SPADES));
		cards.add(new Card(Rank.EIGHT, Suit.SPADES));
		cards.add(new Card(Rank.NINE, Suit.SPADES));
		cards.add(new Card(Rank.TEN, Suit.SPADES));
		cards.add(new Card(Rank.JACK, Suit.SPADES));
		cards.add(new Card(Rank.QUEEN, Suit.SPADES));
		cards.add(new Card(Rank.KING, Suit.SPADES));
		cards.add(new Card(Rank.ACE, Suit.SPADES));
		cards.add(new Card(Rank.TWO, Suit.CLUBS));
		cards.add(new Card(Rank.THREE, Suit.CLUBS));
		cards.add(new Card(Rank.FOUR, Suit.CLUBS));
		cards.add(new Card(Rank.FIVE, Suit.CLUBS));
		cards.add(new Card(Rank.SIX, Suit.CLUBS));
		cards.add(new Card(Rank.SEVEN, Suit.CLUBS));
		cards.add(new Card(Rank.EIGHT, Suit.CLUBS));
		cards.add(new Card(Rank.NINE, Suit.CLUBS));
		cards.add(new Card(Rank.TEN, Suit.CLUBS));
		cards.add(new Card(Rank.JACK, Suit.CLUBS));
		cards.add(new Card(Rank.QUEEN, Suit.CLUBS));
		cards.add(new Card(Rank.KING, Suit.CLUBS));
		cards.add(new Card(Rank.ACE, Suit.CLUBS));
		cards.add(new Card(Rank.TWO, Suit.HEARTS));
		cards.add(new Card(Rank.THREE, Suit.HEARTS));
		cards.add(new Card(Rank.FOUR, Suit.HEARTS));
		cards.add(new Card(Rank.FIVE, Suit.HEARTS));
		cards.add(new Card(Rank.SIX, Suit.HEARTS));
		cards.add(new Card(Rank.SEVEN, Suit.HEARTS));
		cards.add(new Card(Rank.EIGHT, Suit.HEARTS));
		cards.add(new Card(Rank.NINE, Suit.HEARTS));
		cards.add(new Card(Rank.TEN, Suit.HEARTS));
		cards.add(new Card(Rank.JACK, Suit.HEARTS));
		cards.add(new Card(Rank.QUEEN, Suit.HEARTS));
		cards.add(new Card(Rank.KING, Suit.HEARTS));
		cards.add(new Card(Rank.ACE, Suit.HEARTS));
		cards.add(new Card(Rank.TWO, Suit.DIAMONDS));
		cards.add(new Card(Rank.THREE, Suit.DIAMONDS));
		cards.add(new Card(Rank.FOUR, Suit.DIAMONDS));
		cards.add(new Card(Rank.FIVE, Suit.DIAMONDS));
		cards.add(new Card(Rank.SIX, Suit.DIAMONDS));
		cards.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
		cards.add(new Card(Rank.EIGHT, Suit.DIAMONDS));
		cards.add(new Card(Rank.NINE, Suit.DIAMONDS));
		cards.add(new Card(Rank.TEN, Suit.DIAMONDS));
		cards.add(new Card(Rank.JACK, Suit.DIAMONDS));
		cards.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
		cards.add(new Card(Rank.KING, Suit.DIAMONDS));
		cards.add(new Card(Rank.ACE, Suit.DIAMONDS));
	
	}
	
	public int checkDeckSize() {
		return cards.size();
	}
	public Card dealCard() {
		return cards.remove(0);
	}
	public void shuffleDeck() {
		Collections.shuffle(cards);
	}
}
