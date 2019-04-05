package com.skilldistillery.cards.common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	Scanner sc = new Scanner(System.in);
	Deck deck = new Deck();

	public static void main(String[] args) {
		new Game().launch();

	}

	public void launch() {
		boolean deal = true;
		int numCards = 0;

		while (deal) {
			System.out.println("How many cards do you want?");
			try {
				numCards = sc.nextInt();
				if (numCards > 0 && numCards < 53) {
					deal = false;
				} else {
					System.out.println("Enter a number between 1 and 52");
				}

			} catch (InputMismatchException e) {
				System.err.println("Enter a number between 1 and 52");
				sc.nextLine();
			}
		}
		deal(numCards);
	}

	public void deal(int numCards) {
		deck.shuffleDeck();
		int total = 0;
		while (numCards > 0) {
			Card card = deck.dealCard();
			System.out.println(card);
			total += card.getValue();
			numCards --;
		}
		System.out.println("Your total is " + total);
	}

}
