package com.capgemini.assignments.assignment17;
import java.util.Scanner;

public class assignment17 {
	static String name;
	static Player playerlist = null;
	static String country;
	static String skill;
	static String teamname;
	static String mdate;
	static Team team1;
	static Team team2;
	static String venue;

	public static void main(String[] args)
	{
		//player

		Scanner sc=new Scanner(System.in);
		int pc = 0;
		while(pc==0) {
			try{
				System.out.println("Enter Player count");
				pc = Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Enter a number!");
			} 
		}
		Player[] p=new Player[pc];
		for(int i=0;i<p.length;i++) {
			System.out.println("Enter player "+(i+1)+" details: ");
			String data=sc.nextLine();
			PlayerBO details = new PlayerBO();
			details.createPlayer(data);
			p[i]=new Player(name,country,skill);
			//System.out.println(p[i]);
		}
		//team
		int tc = 0;
		while(tc==0) {
			try{
				System.out.println("Enter Team count");
				tc = Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Enter a number!");
			} 
		}
		Team[] t=new Team[tc];
		for(int i=0;i<p.length;i++) {
			System.out.println("Enter Team "+(i+1)+" details: ");
			String team=sc.nextLine();
			TeamBO teamdetails = new TeamBO();
			teamdetails.createTeam(team,p);
			t[i]=new Team(teamname,playerlist);
			//System.out.println(t[i]);
		}
		//match
		int mc = 0;
		while(mc==0) {
			try{
				System.out.println("Enter Match count");
				mc = Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Enter a number!");
			} 
		}
		Match[] m=new Match[mc];
		for(int i=0;i<m.length;i++) {
			System.out.println("Enter Match "+(i+1)+" details: ");
			String match=sc.nextLine();
			MatchBO matchdetails = new MatchBO();
			matchdetails.createMatch(match,t);
			m[i]=new Match(mdate,team1,team2,venue);
			//System.out.println(m[i]);
		}
		//Menu
		boolean menu = false;
		while(!menu) {
			System.out.println("Menu:");
			System.out.println("1) Find Team ");
			System.out.println("2) Find All Matches In A Specific Venue ");
			System.out.println("Type 1 or 2 ");
			int cc = 0;
			try {
				System.out.println("Enter your choice");
				cc = Integer.parseInt(sc.nextLine());
				if(cc == 1) {
					System.out.println("Enter Match date ");
					String matchdate=sc.nextLine();
					new MatchBO().findTeam(matchdate,m);
					boolean yesorno = false;
					while(!yesorno) {
						System.out.println("Do you want to continue? Type Yes or No");
						String wish=sc.nextLine();
						if(wish.equalsIgnoreCase("yes")) {
							break;
						}
						if(wish.equalsIgnoreCase("no")) {
							System.exit(1);
						}
						else if(!wish.equalsIgnoreCase("yes") || !wish.equalsIgnoreCase("no")) {
							System.out.println("Type Yes or No Only!");
						}
					}
				}
				if(cc==2) {
					System.out.println("Match details: ");
					System.out.println("Enter Team Name");
					String menuteamname=sc.nextLine();
					new MatchBO().findAllMatchesOfTeam(menuteamname,m);
					boolean yesorno = false;
					while(!yesorno) {
						System.out.println("Do you want to continue? Type Yes or No");
						String wish=sc.nextLine();
						if(wish.equalsIgnoreCase("yes")) {
							break;
						}
						if(wish.equalsIgnoreCase("no")) {
							System.exit(1);
						}
						else if(!wish.equalsIgnoreCase("yes") || !wish.equalsIgnoreCase("no")) {
							System.out.println("Type Yes or No Only!");
						}
					}

				}
				else if(cc != 1 || cc!=2) {
					System.out.println("Type 1 or 2 only");
				}
			}catch(Exception e) {
				System.out.println("Type 1 or 2 only");
			} 
		}
	}


}
class Player{
	private String name,country,skill;

	public String getName() {
		return name;
	}
	public String getCountry() {
		return country;
	}
	public String getSkill() {
		return skill;
	}

	public Player(String name, String country, String skill) {
		super();
		this.name = name;
		this.country = country;
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", country=" + country + ", skill=" + skill + "]";
	}

}
class PlayerBO extends assignment17{
	Player createPlayer (String data) {
		String[] arrSplit = data.split(",");
		name=arrSplit[0];
		country=arrSplit[1];
		skill=arrSplit[2];
		return null;

	}
}
class Team{
	String name;
	Player player;

	public Team(String name, Player player) {
		super();
		this.name = name;
		this.player = player;
	}
	public String getName() {
		return name;
	}
	public Player getPlayer() {
		return player;
	}
	@Override
	public String toString() {
		return "Team [name=" + name + ", player=" + player + "]";
	}

}
class TeamBO extends assignment17{
	public Team createTeam(String data, Player[] PlayerList) {
		String[] arrSplit = data.split(",");
		int found=0;
		teamname=arrSplit[0];
		String tname=arrSplit[1].trim();
		for(int i=0;i<PlayerList.length;i++)
		{
			if(PlayerList[i].getName().equalsIgnoreCase(tname)) {
				found++;
				playerlist = PlayerList[i];
			} 
		}
		if(found ==0)
		{
			System.out.println("No Player found terminating program");
			System.exit(1);
		}
		return null;

	}
}
class Match{
	String date;
	Team teamone;
	Team teamtwo;
	String Venue;
	//Team team;
	public String getDate() {
		return date;
	}
	public Team getTeamone() {
		return teamone;
	}
	public Team getTeamtwo() {
		return teamtwo;
	}
	public String getVenue() {
		return Venue;
	}/*
	public Team getTeam() {
		return team;
	}*/
	public Match(String date, Team teamone, Team teamtwo, String venue) {
		super();
		this.date = date;
		this.teamone = teamone;
		this.teamtwo = teamtwo;
		Venue = venue;
		//this.team = team;
	}
	@Override
	public String toString() {
		return "Match [date=" + date + ", teamone=" + teamone + ", teamtwo=" + teamtwo + ", Venue=" + Venue 
				+ "]";
	}

}
class MatchBO extends assignment17{
	public Match createMatch(String data, Team[] teamList) {
		int found=0;
		String[] arrSplit = data.split(",");
		mdate=arrSplit[0];
		String steam1=arrSplit[1].trim();
		String steam2=arrSplit[2].trim();
		venue=arrSplit[3];
		for(int i=0;i<teamList.length;i++)
		{
			if(teamList[i].getName().equalsIgnoreCase(steam1)) {
				found++;
				team1 = teamList[i];
			}
			if(!teamList[i].getName().equalsIgnoreCase(steam1) && teamList[i].getName().equalsIgnoreCase(steam2)) {
				found++;
				team2 = teamList[i];
			} 
		}
		if(found != 2)
		{
			System.out.println("Please check the Teams");
			System.exit(1);
		}
		return null;

	}
	public Team findTeam(String matchDate, Match[] matchList) {
		int found=0;
		for(int i=0;i<matchList.length;i++)
		{
			if(matchList[i].getDate().equalsIgnoreCase(matchDate.trim())) {
				System.out.println(matchList[i].getTeamone().name+", "+matchList[i].getTeamtwo().name);
				found++;
			}
		}
		if(found == 0)
		{
			System.out.println("No Match Found!");
		}
		return null;

	}
	public void findAllMatchesOfTeam(String teamName, Match[] matchList) {
		int found=0;
		System.out.printf("%-15s %-15s %-15s %s","Date","TeamOne","TeamTwo","Venue\n");
		for(int i=0;i<matchList.length;i++)
		{
			if(matchList[i].getTeamone().name.equalsIgnoreCase(teamName.trim()) || matchList[i].getTeamtwo().name.equalsIgnoreCase(teamName.trim())) {
				System.out.printf("%-15s %-15s %-15s %s",matchList[i].getDate().toString(),matchList[i].getTeamone().name,matchList[i].getTeamtwo().name,matchList[i].getVenue().toString());
				System.out.printf("\n");
				found++;
			}
		}
		if(found == 0)
		{
			System.out.println("No Match Found!");
		}
	}
}
