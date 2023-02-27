package com.capgemini.assignments.assignment16;

import java.util.Scanner;

class Player{
	String name, country;
	Skill skill;
	Player(String name,String country,Skill skill){
		this.name=name;
		this.country=country;
		this.skill=skill;
	}
	String getname() {
		return name;
	}
	String getcountry(){
		return country;
	}
	Skill getskill() {
		return skill;
	}
}
class Skill{
	String skillName;
	String getskillName() {
		return skillName;
	}
}

class PlayerBO{
	void viewDetails(Player[] playerList) {
		System.out.println("Player\tCountry\tSkill");
		for(int i=0;i<playerList.length;i++)
	     {
			System.out.println(playerList[i].getname()+"\t"+playerList[i].getcountry()+"\t"+playerList[i].skill.getskillName());
	     }
	}
	void printPlayerDetailsWithSkill(Player[] playerList, String skill) {
		System.out.println("Player\tCountry\tSkill");
		for(int i=0;i<playerList.length;i++)
	      {
	        if(skill.equalsIgnoreCase(playerList[i].skill.getskillName()))
	        {
	        	System.out.println(playerList[i].getname()+"\t"+playerList[i].getcountry()+"\t"+playerList[i].skill.getskillName());
	        }
	      }
	}
}
class assignment16{
	public static void main(String[] args)
	   {
		System.out.println("Enter number of Players");
	    Scanner sc=new Scanner(System.in);
	    int np = sc.nextInt();
	    String sk = null;
	    Player[] p=new Player[np];
	    for(int i=0;i<p.length;i++) {
			sc.nextLine();
	    	System.out.println("Enter player "+(i+1)+" details: ");
	    	System.out.println("Enter player name");
	    	String name=sc.nextLine();
	    	System.out.println("Enter country name");
	    	String country=sc.nextLine();
	    	System.out.println("Enter Skill");
	    	Skill skill= new Skill();
	    	skill.skillName = sc.nextLine();
		    p[i]=new Player(name,country,skill);
		    }
	    boolean re = true;
		while(re) {
			System.out.println("Menu:");
			System.out.println("1. View details");
			System.out.println("2. Filter player with skill");
			System.out.println("3. Exit");
			int menu = sc.nextInt();
			if (menu == 1) {	
				PlayerBO details = new PlayerBO();
				details.viewDetails(p);
			}if (menu == 2) {
				System.out.println("Enter Skill");
				sc.nextLine();
				sk = sc.nextLine();
				PlayerBO details = new PlayerBO();
				details.printPlayerDetailsWithSkill(p,sk);
			}else if(menu == 3) {
				re=false;
			}
		}
	   }
	
}
