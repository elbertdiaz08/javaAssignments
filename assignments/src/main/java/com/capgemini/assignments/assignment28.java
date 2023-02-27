package com.capgemini.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class assignment28 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		List<Player> playerList = new ArrayList<>();
		Player captain =new Player();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of players ");
		int n = Integer.parseInt(input.readLine());
		String choice = null;
		do {
			System.out.println("Do you know the details of the captain? Type Yes / No ");
			choice = input.readLine();
			switch(choice) {
			case "yes":
				System.out.println("Enter name of the captain ");
				String name=input.readLine().trim();
				System.out.println("Enter country of the captain ");
				String country=input.readLine().trim();
				System.out.println("Enter skillset of the captain ");
				String skill=input.readLine().trim();
				captain = new Player(name,country,skill);
				choice = "no";
				break;

			case "no":
				choice = "no";
				break;

			default:
				System.out.println("Do you know the details of the captain? Type Yes / No ");
			}

		}while(!choice.equalsIgnoreCase("no"));
		for(int i=0;i<n;i++) {
			System.out.println("Enter name of player "+ (i+1));
			String name=input.readLine().trim();
			System.out.println("Enter country of player "+ (i+1));
			String country=input.readLine().trim();
			System.out.println("Enter skillset of player "+ (i+1));
			String skill=input.readLine().trim();
			Player player = new Player(name,country,skill);
			playerList.add(player);
		}
		PlayerBO.displayPlayerDetails(playerList,captain);
	}
}

class Player{
	String name,country,skill;

	public Player(String name, String country, String skill) {
		super();
		this.name = name;
		this.country = country;
		this.skill = skill;
	}

	public Player() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
}

class PlayerBO{
	static void displayPlayerDetails(List<Player> playerList,Player captain){
		try {
			if(!captain.getName().equalsIgnoreCase(null))
				System.out.println(captain.getName()+","+captain.getCountry()+","+captain.getSkill());
		}catch(NullPointerException e) {
			System.out.println("Exception Occured : java.lang.NullPointerException ");
			System.out.println("Captain details not available");
		}
		System.out.println("Player Details ");
		for(Player player:playerList) {
			System.out.println(player.getName()+","+player.getCountry()+","+player.getSkill());
		}
	}
}