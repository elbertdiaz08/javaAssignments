package com.capgemini.assignments.assignment19;

import java.util.Scanner;

public class assignment19 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int oc = 0;
		while(oc==0) {
			try{
				System.out.println("Enter number of matches ");
				oc = Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Enter a number!");
			} 
		}
		Match[] match=new Match[oc];
		Outcome[] outcome= new Outcome[oc];
		for(int i=0;i<match.length;i++) {
			System.out.println("Enter match "+(i+1)+" details: ");
			System.out.println("Enter match date ");
			String mdate = sc.nextLine().trim();
			System.out.println("Enter team one ");
			String team1 = sc.nextLine().trim();
			System.out.println("Enter team two ");
			String team2 = sc.nextLine().trim();
			System.out.println("Enter venue ");
			String venue = sc.nextLine().trim();
			System.out.println("Enter status ");
			String status = sc.nextLine().trim();
			System.out.println("Enter winner Team ");
			String winnerteam = sc.nextLine().trim();
			outcome[i]=new Outcome(status,winnerteam);
			match[i]=new Match(mdate,team1,team2,venue,outcome[i]);
		}
		boolean menu = false;
		while(!menu) {
			System.out.println("Menu");
			System.out.println("1.View match details  ");
			System.out.println("2.Filter match details with outcome status ");
			System.out.println("3.Filter match details with outcome winner team ");
			System.out.println("4.Exit ");
			int cc = 0;
			try {
				System.out.println("Enter your choice");
				cc = Integer.parseInt(sc.nextLine());
				if(cc == 1) {
					new MatchBO().printAllMatchDetails(match);
				}
				if(cc==2) {
					System.out.println("Enter outcome status ");
					String outcome1 = sc.nextLine().trim();
					new MatchBO().printMatchDetailsWithOutcomeStatus(match,outcome1);
				}
				if(cc==3) {
					System.out.println("Enter outcome status ");
					String winner = sc.nextLine().trim();
					new MatchBO().printMatchDetailsWithOutcomeWinnerTeam(match,winner);
				}
				if(cc==4) {
					break;
				}
				else if(cc>4) {
					System.out.println("Type 1 to 4 only");
				}
			}catch(Exception e) {
				System.out.println("Type 1 to 4 only");
				e.printStackTrace();
			} 
		}
	}
}


class Outcome{
	String status, winnerTeam;

	public String getStatus() {
		return status;
	}

	public String getWinnerTeam() {
		return winnerTeam;
	}

	public Outcome(String status, String winnerTeam) {
		super();
		this.status = status;
		this.winnerTeam = winnerTeam;
	}

	@Override
	public String toString() {
		return String.format("%-15s %-15s", status, winnerTeam);
	}

}

class Match{
	String date,teamOne,teamTwo,venue;
	Outcome outcome;
	public String getDate() {
		return date;
	}
	public String getTeamOne() {
		return teamOne;
	}
	public String getTeamTwo() {
		return teamTwo;
	}
	public String getVenue() {
		return venue;
	}
	public Outcome getOutcome() {
		return outcome;
	}
	public Match(String date, String teamOne, String teamTwo, String venue, Outcome outcome) {
		super();
		this.date = date;
		this.teamOne = teamOne;
		this.teamTwo = teamTwo;
		this.venue = venue;
		this.outcome = outcome;
	}
	@Override
	public String toString() {
		return String.format("%-15s %-15s %-15s %-15s %-30s",date,teamOne,teamTwo,venue,outcome); 
	}

}

class MatchBO{
	void printAllMatchDetails(Match[] MatchList) {
		System.out.printf("%-15s %-15s %-15s %-15s","Date","Team1","Team2","Venue");
		System.out.printf("%-15s %-15s","Status","Winner");
		System.out.println("");
		for(int i=0;i<MatchList.length;i++) {
			System.out.println(MatchList[i].toString());
		}
	}
	void printMatchDetailsWithOutcomeStatus(Match[] MatchList, String outcomeStatus) {
		System.out.printf("%-15s %-15s %-15s %-15s","Date","Team1","Team2","Venue");
		System.out.printf("%-15s %-15s","Status","Winner");
		System.out.println("");
		for(int i=0;i<MatchList.length;i++) {
			if(MatchList[i].getOutcome().status.equalsIgnoreCase(outcomeStatus))
			System.out.println(MatchList[i].toString());
		}
	}
	void printMatchDetailsWithOutcomeWinnerTeam(Match[] MatchList, String outcomeWinnerTeam) {
		System.out.printf("%-15s %-15s %-15s %-15s","Date","Team1","Team2","Venue");
		System.out.printf("%-15s %-15s","Status","Winner");
		System.out.println("");
		for(int i=0;i<MatchList.length;i++) {
			if(MatchList[i].getOutcome().winnerTeam.equalsIgnoreCase(outcomeWinnerTeam))
			System.out.println(MatchList[i].toString());
		}
	}
}

