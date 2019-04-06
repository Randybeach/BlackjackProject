package com.skilldistillery.cards.players;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Gambler extends Player {
	private int money;
	
	public Gambler(String name) {
		super(name);
		try(BufferedReader br = new BufferedReader(new FileReader("money.txt"))){
			String line;
			while((line = br.readLine()) != null) {
				String [] mon = line.split("\\s");
				money = Integer.parseInt(mon[0]);
				money += 100;
			}
		}catch(FileNotFoundException e) {
			System.err.println(e.getMessage());
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	public void saveMoney() {
		try(PrintWriter bw = new PrintWriter(new FileOutputStream("money.txt"))){
			bw.println(money);
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}
	

	
}
