package com.skilldistillery.cards.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.players.Dealer;
import com.skilldistillery.cards.players.Gambler;

public class Table {
	Scanner sc = new Scanner(System.in);
	Dealer dealer = new Dealer("Dealer");
	Gambler gambler;
	int pot = 0;

	public static void main(String[] args) {
		new Table().play();
	}

	public void play() {
		boolean gambling = true;
		System.out.println("Enter the player name");
		String name = sc.next();
		gambler = new Gambler(name);
		printDeck();

		while (gambling) {
			newGame();
			welcomePlayer();
			gambler.getHand().addCard(deal());
			dealer.getHand().addCard(deal());
			gambler.getHand().addCard(deal());
			dealer.getHand().addCard(deal());
			do {
				printGamblerHand();
				printDealerSecretHand();
				int checkBlackjack = checkBlackjack();
				if (checkBlackjack == 1 || checkBlackjack == 2) {
					break;
				}
				int gamblerLose = gamblerOptions();
				if (gamblerLose == 1) {
					break;
				}
				int dealerLose = dealerOptions();
				if (dealerLose == 1) {
					break;
				}
				evaluateGamblerWinner();
				break;
			} while (true);
			int choice = 0;
			boolean trying = true;
			while (trying) {
				try {
					System.out.println("Do you want to play again?\n1. Yes\n2. No");
					choice = sc.nextInt();
					trying = false;
				} catch (InputMismatchException e) {
					System.err.println("Enter 1 or 2");
					sc.nextLine();
				}
			}
			if (choice == 2) {
				gambling = false;
			} else if (gambler.getMoney() <= 0) {
				System.out.println("You're out of money dude. We are kicking you out.");
				gambling = false;
			}
		}
		gambler.saveMoney();
	}

	public Card deal() {
		if (dealer.checkDeckSize() < 6) {
			dealer.getNewDeck();
			dealer.shuffleDeck();
			System.out.println("Just got a new deck!");
		}
		return dealer.dealCard();
	}

	public void welcomePlayer() {
		System.out.println("Welcome to Blackjack " + gambler.getName() + ". You have $" + gambler.getMoney());
		boolean validWager = false;
		int wager = 0;
		System.out.println("What do you want to wager?");
		while (!validWager) {
			try {
				wager = sc.nextInt();
				if (wager < 1 || wager > gambler.getMoney()) {
					System.out.println("Whoa buddy that isn't right");
				} else {
					validWager = true;
					pot += wager;
				}
			} catch (InputMismatchException e) {
				System.err.println("Enter a wager");
				sc.nextLine();
			}
		}
		if (wager == gambler.getMoney()) {
			System.out.println("YES! " + gambler.getName() + " is ALL IN!!");
		} else if (wager < gambler.getMoney() / 20) {
			System.out.println("That's no fun!");
		} else if (wager >= gambler.getMoney() / 2) {
			System.out.println("Whoa a hefty bet! It's getting exciting!!");
		} else {
			System.out.println("A respectable amount. ");
		}

		System.out.println("Well let's get into it. The dealing has begun.\n");
	}

	public void printGamblerHand() {
		System.out.println(gambler.getName() + " you have " + gambler.getHand().getHandValue() + ":");
		for (Card cards : gambler.getHand().getCards()) {
			System.out.println(cards.toString());
		}
		System.out.println();
	}

	public void printDealerSecretHand() {
		System.out.println(dealer.getName() + " has " + dealer.getPartialHand().getValue() + " that we know of.");
		System.out.println(dealer.getHand().getCards().get(0));
		System.out.println();
	}

	public void printDealerFullHand() {
		System.out.println(dealer.getName() + " has " + dealer.getHand().getHandValue());
		for (Card cards : dealer.getHand().getCards()) {
			System.out.println(cards.toString());
		}
	}

	public int gamblerOptions() {
		boolean gambling = true;
		while (gambling) {
			System.out.println("1. Hit\n2. Stand\n3. Double Down");
			try {
				int choice = sc.nextInt();
				if (choice == 1) {
					gambler.getHand().addCard(deal());
				} else if (choice == 2) {
					gambling = false;
				}else if(choice ==3) {
					doubleDown();
					gambling = false;
				}
			} catch (InputMismatchException e) {
				System.err.println("Enter a number");
				sc.nextLine();
			}
			if (gambler.getHand().getHandValue() > 21) {
				System.out.println("OH BUSTED!!");
				printGamblerHand();
				youLose();
				gambling = false;
				return 1;
			}
			printGamblerHand();
		}
		return 0;
	}

	public int dealerOptions() {
		while (dealer.getHand().getHandValue() < 17) {
			dealer.getHand().addCard(deal());
		}
		if (dealer.getHand().getHandValue() > 21) {
			System.out.println("OH Dealer BUSTED!!");
			printDealerFullHand();
			youWin();
			return 1;
		}
		return 0;
	}

	public void evaluateGamblerWinner() {
		printDealerFullHand();
		if (gambler.getHand().getHandValue() > dealer.getHand().getHandValue()) {
			youWin();
		} else if (gambler.getHand().getHandValue() == dealer.getHand().getHandValue()) {
			System.out.println("WHOA A TIE!! SUDDEN DEATH!!");
		} else {
			youLose();
		}
	}

	public void youWin() {
		System.out.println();
		System.out.println("You are the winner");
		gambler.setMoney(gambler.getMoney() + pot);
		System.out.println("You have $" + gambler.getMoney() + " \n");
	}

	public void youLose() {
		System.out.println();
		System.out.println("House wins!");
		gambler.setMoney(gambler.getMoney() - pot);
		System.out.println("You have $" + gambler.getMoney() + "\n");
	}

	public void newGame() {
		pot = 0;
		gambler.getHand().clearHand();
		dealer.getHand().clearHand();
	}

	public int checkBlackjack() {
		if (gambler.getHand().getHandValue() == 21 && dealer.getHand().getHandValue() < 21) {
			System.out.println(gambler.getName() + " Blackjack!!!");
			youWin();
			return 1;

		} else if (dealer.getHand().getHandValue() == 21 && gambler.getHand().getHandValue() < 21) {
			System.out.println(dealer.getName() + " Blackjack!!!");
			youLose();
			return 2;
		}
		return 0;
	}

	public void printDeck() {
		System.out.println("Would you like to inspect the deck? Yes or No.");

		String choice = sc.next();
		if (choice.equalsIgnoreCase("yes")) {
			int i = 1;
			for (Card cards : dealer.showDeck().cards) {

				System.out.println(i + ": " + cards);
				i++;
			}
			System.out.println();
			dealer.shuffleDeck();
		}
	}
	public void doubleDown() {
		System.out.println("DOUBLING DOWN!!");
		if(pot >= gambler.getMoney()/2) {
			pot = gambler.getMoney();
			System.out.println("You are all in. Pot is now $" + pot + ". You have $0 left to add.");
		}else {
			pot *=2;
			System.out.println("Pot is now $" + pot);
		}
		gambler.getHand().addCard(deal());
	}

}
