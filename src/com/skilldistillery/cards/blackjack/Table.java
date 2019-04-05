package com.skilldistillery.cards.blackjack;

import java.util.Scanner;
import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.players.Dealer;
import com.skilldistillery.cards.players.Gambler;

public class Table {
	Scanner sc = new Scanner(System.in);
	Dealer dealer = new Dealer("Dealer");
	Gambler gambler;
	
	public static void main(String[] args) {
		new Table().play();
	}
	public Table() {
	}
	public void play() {
		boolean playing = true;
		boolean gambling = true;
		while (gambling) {
			welcomePlayer();
			gambler.getHand().addCard(deal());
			dealer.getHand().addCard(deal());
			do {
			printGamblerHand();
			printDealerSecretHand();
			int loser = gamblerOptions();
			if(loser == 1) {
				break;
			}
			int dealerLoser = dealerOptions();
			if(dealerLoser == 1) {
				break;
			}
			evaluateGamblerWinner();
			break;
			}while(true);
		System.out.println("Do you want to play again?\n1. Yes\n2. No");
		int choice = sc.nextInt();
		if(choice == 2) {
			gambling = false;
		}
		}
		System.out.println("Ok see ya next time");
	}

	public Card deal() {
		if (dealer.checkDeckSize() < 6) {
			dealer.getNewDeck();
			dealer.shuffleDeck();
		}
		return dealer.dealCard();
	}

	public void welcomePlayer() {
		System.out.println("Enter the player name");
		String name = sc.next();
		gambler = new Gambler(name);
		System.out.println("Welcome to Blackjack " + gambler.getName() + ". You have $" + gambler.getMoney());
		System.out.println("Well let's get into it. The dealing has begun.");
	}

	public void printGamblerHand() {
			System.out.println(gambler.getName() + "  you have " + gambler.getHand().getHandValue());
	}

	public void printDealerSecretHand() {
		System.out.println(dealer.getName() + " has " + dealer.getPartialHand().getValue() + " and an unknown");
	}
	public void printDealerFullHand() {
		System.out.println(dealer.getName() + " has " + dealer.getHand().getHandValue());
	}
	public int gamblerOptions() {
		boolean gambling = true;
		while(gambling) {
		System.out.println("1. Hit\n2. Stand");
		int choice = sc.nextInt();
		if(choice == 1) {
			gambler.getHand().addCard(deal());
		}else if(choice == 2) {
			gambling = false;
		}
		if(gambler.getHand().getHandValue() > 21) {
			System.out.println("OH BUSTED!!");
			gambling = false;
			return 1;
		}
		printGamblerHand();
		}
		return 0;
	}
	public int dealerOptions() {
		while(dealer.getHand().getHandValue() < 17) {
			dealer.getHand().addCard(deal());
		}
		if(dealer.getHand().getHandValue() > 21) {
			System.out.println("OH Dealer BUSTED!!");
			return 1;
		}
		return 0;
	}
	public void evaluateGamblerWinner() {
		printDealerFullHand();
		if(gambler.getHand().getHandValue() > dealer.getHand().getHandValue()) {
			System.out.println("You are the winner");
		}else if(gambler.getHand().getHandValue() == dealer.getHand().getHandValue()) {
			System.out.println("WHOA A TIE!! SUDDEN DEATH!!");
		}
	}

}
